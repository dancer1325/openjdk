JEP 14: The Tip & Tail Model of Library Development
======================================================================

| Authors | Alex Buckley, Brian Goetz, & Ron Pressler | 
| Owner | Alex Buckley | 
| Type | Informational | 
| Scope | JDK | 
| Status | Active | 
| Discussion | jdk dash dev at openjdk dot org | 
| Reviewed by | Alan Bateman, Mark Reinhold, Paul Sandoz | 
| Created | 2024/09/30 23:14 | 
| Updated | 2025/02/24 23:14 | 
| Issue | 8341287](https://bugs.openjdk.org/browse/JDK-8341287) | 

## Summary

Tip & tail is a release model for software libraries that gives application developers a better experience while helping library developers innovate faster. The*tip*release of a library contains new features and bug fixes, while*tail*releases contain only critical bug fixes. As little as possible is backported from the tip to the tails. The JDK has used tip & tail since 2018 to deliver new features at a faster pace, as well as to provide reliable and predictable updates for users focused on stability.

## Goals

- 
Help the Java ecosystem maintain the balance between innovating rapidly for new development and ensuring stability for long-term deployments.

- 
Recognize that application developers have diverse views about the kinds of changes that make it necessary to update libraries and the JDK.

- 
Ensure that library developers do not have to choose between supporting users of older JDKs and embracing new features (virtual threads, patterns, etc.) that excite users of newer JDKs.

- 
Do not constrain library release cycles, version schemes, or tool choices.

## Motivation

The Java ecosystem has a vibrant collection of libraries, most of which are developed under the same release model: One size fits all. In this model, library developers include a spectrum of updates in each release — new features, functional enhancements, bug fixes, security patches, performance improvements, etc. — and expect all users to upgrade to the new release sooner or later.

The inclusive approach of one-size-fits-all supports rapid evolution in the early part of a library's lifecycle, helping to find a user base among application developers or other library developers. For many years, the JDK itself followed such a model. However, once a library has many users, their needs become diverse, even contradictory. Some users work on systems that are under intensive development; they want new features and functional enhancements, and are willing to upgrade to get them. Other users work on systems that are already deployed; they want minimal change, and will upgrade only to get critical bug fixes and security patches.

Because so many long-lived systems are built on the Java Platform, the latter group of users, focused on stability, is huge. Users focused on stability face a difficult choice when a one-size-fits-all library has a new release: Do they take it and risk failure due to the broad array of changes, or not take it and risk a security breach from not having the latest patches? For those users, the desire to not upgrade is rational, even if it seems strange to developers in teams where staying current is the norm. Eventually, inevitably, users focused on stability will need a fix or patch that only appears in a much newer release, and will likely suffer a painful upgrade.

In addition, one-size-fits-all means that a library has to support a wide range of JDK versions. Most libraries choose a lowest common denominator — the*baseline*, usually JDK 8 — which limits them to using Java features available in the baseline. This frustrates users building new systems, who want libraries to boost developer productivity by embracing modern Java features such asrecords](https://openjdk.org/jeps/395),sealed classes](https://openjdk.org/jeps/409),pattern matching](https://openjdk.org/jeps/441), and theForeign Function & Memory API](https://openjdk.org/jeps/454).

### What about semantic versioning?

Semantic versioning is a scheme for library developers to express whether new versions have major changes, minor changes, or only bug fixes. Does semantic versioning mean that users who embrace change can get it, while users who desire stability can avoid it? Unfortunately not. Semantic versioning distinguishes between new functionality (bump the major or minor version) and bug fixes (bump the patch version), but under one-size-fits-all, users cannot get one without the other. For example, suppose version 2.1 of a library has bugs that are fixed in versions 2.1.1 and 2.1.2, in line with semantic versioning. These updates meet the needs of users focused on stability, but under one-size-fits-all, development of 2.1.x will inevitably cease when version 2.2 or 3.0 appears, incorporating minor and major changes, respectively, that those users do not want.

### The Cascade of Doom

Regardless of whether a library uses semantic versioning, it is common for updates to bring changes in a library's dependencies. This can have the effect of pulling in major updates that frustrate users focused on stability. For example, despite version 2.1.1 of the library having just bug fixes, it might update its dependency on another library from 3.1 to 3.2 to get functional enhancements, and 3.2 of that library might update its own dependency on another library from 4.x to 5.x to access major new features. Users focused on stability will see the entire dependency tree change when they adopt 2.1.1, even though all they wanted was bug fixes in one library and nothing else.

The reason for thisbutterfly effect](https://en.wikipedia.org/wiki/Butterfly_effect)— a small change having systemic effects — is that, fundamentally, we are still practicing one-size-fits-all: New versions roll up all kinds of changes, preventing users from getting just the changes they want. Even if one-size-fits-all seems reasonable for each library in isolation, it stops being reasonable when viewed in the context of real-world dependency trees.

### What about multiple release trains?

Instead of one-size-fits-all, some libraries use multiple release trains to satisfy diverse groups of users. Typically, these libraries are large frameworks — Spring, Lucene, Cassandra, etc. — that undergo significant evolution resulting in new major versions. Their developers recognize that some users cannot or will not adopt these versions, so they create a new release train for each major version and baseline it on a newer JDK version, then offer updates for older major versions in release trains baselined on older JDK versions. For example,Spring Framework 5.x is baselined on JDK 8, while 6.x is baselined on JDK 17](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions).

The multi-train model lets libraries serve a diverse user base while embracing new Java features. However, multiple trains are costly if too many updates flow between them. Backporting features and enhancements to old trains takes time and energy that could have been used to evolve the new train. Users focused on stability do not want these backports anyway — they would prefer old trains to have just bug fixes and security patches, but for as long as possible.

### The way forward: Tip & tail development

We believe there is a release model for libraries that is better at serving the needs of the Java ecosystem than both the one-size-fits-all and multi-train models, while also being cheaper for library developers. The tip & tail model is a streamlined and disciplined form of the multi-train model which gives users focused on stability exactly what they need — fixes and patches, and nothing else — while also giving users building new systems what they want — new features and enhancements, faster. This keeps the Java Platform an attractive choice for new applications while safeguarding the future of existing applications.

## Description

The*tip & tail*model of library development is a streamlined and disciplined form of the multi-train model, where only one release train draws nearly all the work.

In the tip & tail model, library developers offer a release train called the*tip*. Releases in the tip train are about moving forward: They improve the productivity of users building new systems by providing new features and functional enhancements, along with the largest possible set of bug fixes, security patches, and performance improvements. From time to time, library developers designate a tip release as the start of a new*tail*train that they will continue to update even after new tip releases are made. Releases in a tail train are about preserving the status quo: They satisfy the needs of users focused on stability by offering critical bug fixes and security patches — and nothing else.

There is only one tip train, but there can be multiple tail trains. Because the tip train is aimed at a different constituency than the tail trains, the work that goes into the tip train is different from the work in the tail trains. The mantra for library developers is:

- 
Add new features and functional enhancements only in the tip, not in the tails.

- 
Backport as little as possible from the tip to the tails.

- 
Ensure that tail releases depend on the tail releases of other libraries, where available.

Every library that adopts tip & tail makes life a little easier for its users. Users focused on stability can update from one tail release to another in order to get only fixes and patches; to the extent that a library's dependencies embrace tip & tail all the way down, it will trigger a cascade of updates that all have only fixes and patches. At the bottom of the dependency tree, the JDK adopted tip & tail in 2018, so users focused on stability can get tail releases with only fixes and patches, e.g., JDK 17.0.x and JDK 21.0.y. As more libraries embrace tip & tail, the Java ecosystem becomes more coherent: Users building new systems will use tip releases of libraries and the JDK, while users focused on stability will use tail releases of libraries and the JDK.

### Backport as little as possible

Backporting as little as possible is the discipline that distinguishes the tip & tail model of library development from traditional multi-train models. It means backporting, from the tip train to the tail trains, only fixes for critical bugs — that is, bugs that could cause applications to malfunction catastrophically, such as incorrect mathematical calculations — and patches for security vulnerabilities.

This minimal approach reduces the time invested in tail trains so that more time is available to work on the tip train. More time spent on the tip train means that users building new systems get a more capable and performant library sooner. Less churn in the tail trains means that users focused on stability get lower-risk updates, and for longer, since the cost of maintaining tail trains is low.

Backporting as little as possible also means that tip & tail is often less work than one-size-fits-all. Development in the tip train can rely on the feature-rich tip releases of its dependencies, including the JDK, and need not concern itself with older versions of dependencies or running on older JDKs. This more than makes up for the small amount of work ("backport as little as possible") needed to maintain the tail trains.

Here is an example of a tip & tail timeline with two tail trains:

```
TIP:    1.0 -- 2.0 -- 2.1 -- 3.0 -- 3.1 -- 4.0 -- 4.1 -- 4.2 -- 5.0 ...
                       \             \
                        \             \      
TAIL 1:                  \- 2.1.1 -------- 2.1.2 -- 2.1.3 -- 2.1.4 -- 2.1.5 EOL
                                        \
                                         \
TAIL 2:                                   \- 3.1.1 -- 3.1.2 -- 3.1.3 -- ...
```

This will look unremarkable to any library developer familiar with multiple release trains because the impact of tip & tail is seen only in the content of the tails:

- 
The 2.1.x tail does not have any features or enhancements from 3.0 or later.

- 
The 3.1.x tail does not have any features from 4.0 or later.

- 
Both tails have (relevant) security patches from all tip releases up to and including 5.0.

Aside from minimizing backports, tip & tail leaves library developers with many freedoms:

- 
Tip & tail does not specify when or why tail trains are created, nor when or why they are discontinued.

- 
Tip & tail does not constrain a library's release cycle. For example, a new tip release could be made on a regular schedule (time-boxed) or when a significant feature is added (feature-boxed), while a new tail release could be made on a regular schedule, or when a threshold number of bug fixes has been backported, or when a threshold number of severe CVEs have been fixed.

- 
Tip & tail does not dictate a version numbering scheme, the use of alpha/beta/release-candidate labels, or any other metadata about the library.

### Do not backport new features and performance improvements

The effectiveness of tip & tail rests on backporting as little as possible from tip to tail: only critical bug fixes and security patches.

Inevitably, some users will ask for backports of new features or functional enhancements from the tip train because they use tail releases and are unable or unwilling to adopt tip releases. However, wanting new features or functional enhancements implies they are actively evolving their code and would generally be well served by tip releases. This is a conundrum, and the reasons behind it tend to be idiosyncratic, e.g., corporate policies, tool choices, and staffing levels. Library developers should keep in mind that time spent on backporting is time not spent on advancing the tip, thus hurting users building new systems. Backporting new features and functional enhancements also risks destabilizing the tail, thus hurting users focused on stability, which the tail exists to serve.

Similarly, some users will ask for backports of non-critical bug fixes from the tip train. However, backporting even the smallest bug fix has overhead that raises the cost of tail maintenance: testing, documentation, release management (should all tail trains receive the fix, or just one, or some?), etc. In addition, every bug fix has the potential to affect the behavior of someone's code (an experienced JDK developer once observed that"Every change is an incompatible change"](http://web.archive.org/web/20181208123546/https://blogs.oracle.com/darcy/kinds-of-compatibility:-source,-binary,-and-behavioral)). Users focused on stability want their code to behave consistently year after year, and in expectation of getting only critical bug fixes in tail trains, they may have long ago worked around the bug and would be harmed by seeing it fixed. Library developers should document the characteristics of a "critical" bug fix so that proposals to backport fixes can be evaluated quickly and consistently, minimizing the time invested in tails.

Library developers may be tempted to backport performance improvements from the tip train. While some users focused on stability might be able to accept the risk of the changes involved, all users focused on stability can live without them. Not backporting performance improvements is unlikely to cause users focused on stability to abandon a library, because adopting a different library would be even riskier than upgrading to the tip of the current library. There may be exceptions, such as backporting a small performance improvement that is highly localized and and obviously low risk. However, because the effectiveness of tip & tail rests on the low cost of maintaining tails, such exceptions should be kept to a minimum.

### Picking a JDK baseline

Because a library's tip releases are aimed at a different constituency than its tail releases, the baseline JDK version for tip releases may be different than the baseline JDK version for tail releases. The mantra for library developers is:

- 
In the tip train, baseline each tip release on the JDK version that best supports the library's new features and enhancements. The baseline could be the most recent JDK version if, e.g., it contains a new API that significantly improves the library's implementation. Alternatively, the baseline could be an older JDK version that is designated as a long-term support release, e.g., JDK 21.

- 
Baseline a tail train on a JDK version designated as a long-term support release. Keep the baseline as constant as possible over the life of the tail train.

Here is the example tip & tail timeline again, this time decorated with the JDK baseline chosen for each release (in parentheses):

```
TIP:    1.0 -- 2.0 -- 2.1 -- 3.0 -- 3.1 -- 4.0 -- 4.1 -- 4.2 -- 5.0 ...
        (11)   (17)   (17)   (19)   (21)   (22)   (24)   (26)   (28)
                       \             \
                        \             \    
TAIL 1:                  \- 2.1.1 -------- 2.1.2 -- 2.1.3 -- 2.1.4 -- 2.1.5 EOL
                             (17)       \    (17)    (17)     (17)     (17) 
                                         \
                                          \
TAIL 2:                                    \- 3.1.1 -- 3.1.2 -- 3.1.3 -- ...
                                                (21)     (21)     (21)
```

This timeline demonstrates:

- 
It is not necessary to develop tip releases in lock step with the JDK's six-month tip releases. Above, after baselining version 2.0 on JDK 17, the library developers make tip releases on a yearly schedule; this generally results in the baseline being every other JDK version.

- 
It is typical to bump the JDK baseline of the tip train when the library needs new JDK features. Above, the library developers wanted to use the Foreign Function & Memory API introduced in JDK 22, so they made a tip release baselined on JDK 22 and bumped the version from 3.1 to 4.0. They also forked a tail train from 3.1 to serve applications unable to upgrade to JDK 22.

- 
It is wise to baseline tail trains on JDK versions which are designated as long-term support (LTS) releases by reputable vendors. Above, the library developers forked tail trains from 2.1 and 3.1 because those tip releases are baselined on JDK 17 and 21, which are designated as LTS releases. It would be unwise to fork a tail train from 3.0 because its baseline, JDK 19, is not designated as an LTS release.

Once a tail train of a library is baselined on a JDK version with a tail train, users focused on stability can expect a stream of conservative updates to the library and its dependencies, including the JDK. For example, with the 2.1.x tail train baselined on JDK 17, users of 2.1.x can upgrade to the latest JDK 17.0.y release and benefit from critical bug fixes. It is, however, inevitable that some users will run 2.1.x on newer JDKs such as 21 or 25, and report problems to the library developer. What these users are really saying is that they expect the library developer to test each 2.1.x release on many JDK versions, not just on JDK 17. This expectation is unfair: Library developers generally prefer to spend time working on tip releases, not testing a matrix of tail releases and JDK versions. Because tip & tail keeps the cost of maintaining tail trains low, the library developer can afford to offer the 2.1.x tail for users on JDK 17, and the 3.1.x tail for users on JDK 21.

### Success with tip & tail

The Java library with the most diverse user base is the JDK itself. To cater to millions of developers, the JDK historically used a multi-train model: A major release was produced every few years, each with a stream of minor releases every few months. For example, JDK 8 in 2014 was followed by dozens of JDK 8uXX releases over the next five years. Although this modeldated back decades](https://www.java.com/releases/fullmatrix/), it had significant flaws:

- 
Major releases were gated by large new features in the Java language and API, making them prone to unpredictable delays. Users building new systems and desiring innovation had to wait for years before they could enjoy features such as lambda expressions and the Stream API.

- 
Minor releases could not alter the Java language or API, but did add and change significant features in the Java runtime. For example,JDK 7u40](https://www.oracle.com/java/technologies/javase/7u40-relnotes.html)added Java Flight Recorder (JFR), which meant significant implementation change in the JVM, whileJDK 8u20](https://www.oracle.com/java/technologies/javase/8u20-relnotes.html)changed the well known location of JDK binaries, breaking third-party scripts.

- 
Many minor releases did, in fact, contain only security patches, but they were inevitably superseded by a one-size-fits-all minor release that contained security patches and new features. For example, users who were happy with JDK 8u5 had no way of getting only bug fixes and security patches, plus administrative updates such as timezone data, once JDK 8u20 was released. Many users decided to stick with older, known-good minor releases to avoid the churn in newer minor releases, even at the risk of being vulnerable to new security exploits.

The dissatisfaction from both innovation-seeking and stability-seeking users was the reason for the change of release model after JDK 9. In 2018, the OpenJDK Communityadopted the tip & tail model](https://mail.openjdk.org/pipermail/discuss/2017-September/004281.html)for ongoing development of the JDK, starting with JDK 10. Six years on, the model is working well:

- 
New features and enhancements in the Java language and API are added only in the tip train. Development in the tip train is time-boxed, with a new tip release every six months: JDK 18 and 19 in 2022, JDK 20 and 21 in 2023, and so forth. Tip releases are called*feature releases*. Users building new systems benefit from the rapid stream of innovation in feature releases.

- 
Every tip release of the JDK is forked to create a tail train.Backports to tail trains](https://wiki.openjdk.org/display/JDKUpdates/JDK11u#JDK11u-FixApprovals)are primarily security patches and low-risk bug fixes. Development in tail trains is time-boxed, with a new tail release every three months: 18.0.1, 18.0.2, and so forth. Tail releases are called*update releases*.

- 
Most JDK vendors have designated JDK versions 8, 11, 17, and 21 as long-term support (LTS) releases. This means that vendors backport to those tail trains for many years and provide update releases every January, April, July, and October. Users focused on stability get the low churn that they desire from these update releases.

- 
For other JDK versions, the norm is two update releases, after which maintenance of the tail train ceases because the tip train has a new release (that is, a new feature release). Users who want to stay up to date with new features and/or enjoy the largest possible set of performance improvements, bug fixes, and security patches, can do so by running each feature release and its two update releases: JDK*N*, JDK*N*.0.1, JDK*N*.0.2, then JDK*N+1*, JDK*N+1*.0.1, JDK*N+1*.0.2, etc. Informally, it is convenient to say that these users are running the tip of the JDK, even though the *.0.1 and *.0.2 update releases are technically from a tail train.

- 
Like any process change, adopting a new release model requires a change in mindset and tends to encounter skepticism, especially the concern that it requires more work. The developers of the JDK expressed such skepticism at first, but following the mantra of minimal backports led to a marked reduction in effort.

Spring Boot](https://spring.io/projects/spring-boot)is an example of a library that hasadopted tip & tail](https://github.com/spring-projects/spring-boot/wiki/Team-Practices). New features are added only in the tip train; only bug fixes are backported to tail trains. Development in the tip train is time-boxed, with a new tip release every six months: Spring Boot 2.7 and 3.0 in 2022, Spring Boot 3.1 and 3.2 in 2023, and so forth. Tip releases are forked regularly to create tail trains, which generally are short-lived. However, the tip release that represents the end of a generation, e.g., Spring Boot 2.7, becomes the root of a tail train that ismaintained for much longer](https://spring.io/blog/2025/02/13/support-policy-updates).

## Q & A

*As a library developer, if I baseline my tip releases on JDK 21, won't I be abandoning my users on JDK 8 and 17?*

No, because you can give those users tail releases baselined on JDK 8 and 17 with hardly any effort. Backporting as little as possible means the cost of maintaining a tail train is low, so library developers can afford to fork tail trains more liberally and keep updating them for longer.

*As a library developer, I already have multiple release trains for the library; am I doing tip & tail?*

Multiple release trains are necessary but not sufficient for tip & tail. The key is to backport as little as possible to older trains. This means saying "no" to contributors and users who want more backporting activity.

## Risks & Assumptions

- 
As a simplifying assumption, we have drawn a bright line between users building new systems and users focused on stability. In reality, most users are focused on both: Some parts of their code are changing, while other parts are stable. For a changing part, users should look for tip releases of its dependencies; for a stable part, users should look for tail releases of its dependencies. For example, an application might use a tip release of a web framework and a tail release of a job scheduling library.

- 
A risk of adopting tip & tail is that some users cling to the one-size-fits-all model: They enjoy the stability of tail releases, but also expect a selection of new features and enhancements to be backported to tail releases from the tip release. Although these users may not see themselves as being on the cutting edge, their best option is to use the tip release: It provides the new features and enhancements that they want, and incorporates all the fixes and patches that they need. A well-maintained library's tip releases are just as stable as its tail releases, and they receive the lion's share of fixes and patches. For example, the tip train of the JDK sees an order of magnitude more bug fixes than the tail trains.