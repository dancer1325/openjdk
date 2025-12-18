JEP 3: JDK Release Process
======================================================================

| Owner | Mark Reinhold | 
| Type | Process | 
| Scope | JDK | 
| Status | Active | 
| Discussion | jdk dash dev at openjdk dot java dot net | 
| Created | 2018/06/19 16:58 | 
| Updated | 2024/12/02 21:41 | 
| Issue | 8205352](https://bugs.openjdk.org/browse/JDK-8205352) | 

## Summary

Define the process by which Contributors in the OpenJDK Community produce time-based, rapid-cadence JDK feature releases.

## Quick reference

This table is provided here for easy access; the terminology it uses is defined below.

|  | Candidates | Fix | Drop | Defer | Enhance? | 
| RDP 1 | Current P1–P3
Targeted P1–P3](https://openjdk.org/s/jdk-rdp-1) | Current P1–P3
Targeted P1–P3 if time
P1–P5 doc/test changes | All P4–P5
Targeted P1–P3 | Current P1–P2,
withapproval](#Bug-Deferral-Process) | With
approval](#Late-Enhancement-Request-Process) | 
| RDP 2 | Current P1–P2
Targeted P1–P2](https://openjdk.org/s/jdk-rdp-2) | Current P1–P2,
withapproval](#Fix-Request-Process)
P1–P5 doc/test changes | All P3–P5
Targeted P1–P2 | Current P1–P2,
withapproval](#Bug-Deferral-Process) | With
approval](#Late-Enhancement-Request-Process) | 
| RC | Current P1
Targeted P1](https://openjdk.org/s/jdk-rc) | Current P1,
withapproval](#Fix-Request-Process) | All P2–P5
Targeted P1 | Current P1,
withapproval](#Bug-Deferral-Process) | No | 

## Overview

Ongoing JDK development takes place in the main-line repository of theJDK Project](https://openjdk.org/projects/jdk),`openjdk/jdk`](https://github.com/openjdk/jdk). This repository is always open for new work.

Every six months, in June and December, we initiate the release cycle for the next JDK feature release, hereinafter referred to as JDK $N. We fork the main-line repository into a*stabilization repository*,`jdk/jdk$N`, and use that repository for the remaining work needed to stabilize the release. That work proceeds over the next three months in three phases, described below:

- Rampdown Phase One(RDP 1)](#rdp-1)[candidate bugs](https://openjdk.org/s/jdk-rdp-1)]
- Rampdown Phase Two(RDP 2)](#rdp-2)[candidate bugs](https://openjdk.org/s/jdk-rdp-2)]
- Release-Candidate Phase(RC)](#rc)[candidate bugs](https://openjdk.org/s/jdk-rc)]

The durations of the phases can vary from release to release, but as an example the phases forJDK 11](https://openjdk.org/projects/jdk/11)were four weeks for RDP 1, three weeks for RDP 2, and five weeks for RC.

Each successive phase narrows the set of bugs that we examine, and subjects actions taken on those bugs to an increasingly-higher level of review. This ensures that, in each phase, we fix the bugs that need to be fixed at that time. It also ensures that we understand why we’re not fixing some bugs that perhaps ought to be fixed but, for good reason, are better left to a future release. The phases thus make use of two approval processes, also described below:

- Bug-Deferral Process](#Bug-Deferral-Process)[pending requests](https://openjdk.org/s/jdk-defer-pending)]
- Fix-Request Process](#Fix-Request-Process)[pending requests](https://openjdk.org/s/jdk-fix-pending)]

The overall feature set is frozen at RDP 1. No furtherJEPs](https://openjdk.org/jeps)will be targeted to the release after that point.

Late, low-risk enhancements that add small bits of missing functionality or improve usability are permitted with approval in RDP 1 and RDP 2, especially when justified by developer feedback or JCP EG support, but the bar is very high in RDP 1 and extraordinarily high in RDP 2. You can request approval for a late enhancement via a third process:

- Late-Enhancement Request Process](#Late-Enhancement-Request-Process)[pending requests](https://openjdk.org/s/jdk-enhancement-pending)]

## Candidate bugs

Each phase is driven by a list of*candidate bugs*. The candidate bugs in each phase are at or above that phase’s*priority threshold*, which starts at P3 for RDP 1 and then increases to P2 for RDP 2 and P1 for RC. Each candidate bug is either

- 
A*current bug*, discovered in an early-access build of JDK $N and reported against that release via the*Affects Version*field, or

- 
A*targeted bug*, reported against some past release but targeted, via the*Fix Version*field, to JDK $N.

A*critical*bug is a current bug whose priority is either P1 or P2 (in RDP 1 and RDP 2) or P1 (in RC).

Queries for the candidate bugs for each phase are defined in JBS. To summarize:

|  | Priority | Critical | Query | 
| RDP 1 | ≥ P3 | ≥ P2 | openjdk.org/s/jdk-rdp-1](https://openjdk.org/s/jdk-rdp-1) | 
| RDP 2 | ≥ P2 | ≥ P2 | openjdk.org/s/jdk-rdp-2](https://openjdk.org/s/jdk-rdp-2) | 
| RC | = P1 | = P1 | openjdk.org/s/jdk-rc](https://openjdk.org/s/jdk-rc) | 

## Actions in a phase

In each phase we aim to*fix*,*drop*, or*defer*each candidate bug. If you’re responsible for a candidate bug then please take one of the following actions:

- 
**Fix**If the bug is current then develop a fix and either integrate it when ready (in RDP 1) or request approval to integrate it via thefix-request process](#Fix-Request-Process)(RDP 2 and RC). In RDP 1, if the bug is targeted and if time permits, develop and integrate a fix when ready.

- 
**Drop**If the bug is targeted, but not critical, then drop it from the release by either

  - 
Clearing the*Fix Version*field, or

  - 
Setting the*Fix Version*field to $N + 1 if you’re reasonably confident that you’ll fix the bug in the next release, or

  - 
Setting the*Fix Version*field to`tbd`if you’ve determined that the fix will not make the next release but might make some later release.

- 
**Defer**If the bug is critical but cannot be fixed in time, or is too risky to fix, then request approval to defer the bug from the release via thebug-deferral process](#Bug-Deferral-Process).

In any case, do not change the priority of a bug in order to remove it from the candidate list. The priority of a bug should reflect the importance of fixing it independent of any particular release, as has been standard practice for the JDK for many years.

### Non-candidate bugs

If you’re responsible for a non-candidate bug that’s targeted to JDK $N via the*Fix Version*field then please drop it by either clearing that field, or setting it to $N + 1, or setting it to`tbd`, as above. There’s no need to defer such bugs via the deferral process.

### Test and documentation bugs and enhancements

Bugs and enhancements of any priority that only affect tests, or test-problem lists, or documentation may be addressed in RDP 1 and RDP 2. You don’t need to request approval for such a change in order to integrate it, but please do make sure that the issue has a`noreg-self`or`noreg-doc`label](https://openjdk.org/guide/#noreg), as appropriate.

## Integrating fixes and enhancements

Most fixes and enhancements intended for the stabilization release will also be applicable to the main-line release. To make such a change in the stabilization release:

- 
Target the relevant JBS issue to the main-line release, immediately create a backport of that issue, and target the backport to the stabilization release.

- 
Create a PR to integrate your change into the main-line repository.

- 
After you obtain any necessary approvals, backport the main-line PR to the stabilization repository via the Skara`/backport`command or, if necessary, by manually opening a backport PR with the title`Backport $HASH`, where`$HASH`is the original commit hash.

All such backports require re-review, even if they areclean](https://wiki.openjdk.org/display/SKARA/Backports#Backports-Terminology), in order to ensure stability. (The Developers’ Guide contains more information onworking with backports](https://openjdk.org/guide/#working-with-backports-in-jbs).)

Some fixes and enhancements will be specific to the stabilization release and not applicable to the main-line release. Integrate such changes directly into the stabilization repository.

In order to make sure that no backports are missed, prior to theRDP 2](#rdp-2)andRC](#rc)phases JDK Contributors will be reminded to review bug fixes that have been integrated into the main-line repository but not backported to the stabilization repository. These JBS queries can be useful:

- Bug fixes not backported from the main line](https://bugs.openjdk.org/issues/?filter=44264)
- My bug fixes not backported from the main line](https://bugs.openjdk.org/issues/?filter=44268)

## Bug-Deferral Process

This process applies fromRDP 1](#rdp-1)until the end of the release.

### Requesting a deferral

If you own a bug that will not be fixed in the current phase of development then you can request a deferral as follows: Update the JBS issue to add a comment whose first line is “Deferral Request”. In that comment briefly describe the reason for the deferral (*e.g.*, insufficient time, complexity or risk of fix,*etc.*). Add the label`jdk$N-defer-request`to the issue, substituting the actual release version number for`$N`.

Deferrals will not be granted for TCK issues identified by the label`tck-red-$N`, except possibly when new TCK tests are involved. Deferrals are unlikely for bugs that prevent release testing.

### Reviewing deferral requests

TheArea Leads, relevant Group Leads, and the JDK Project Lead](https://openjdk.org/projects/jdk/leads)will review thepending deferral requests](https://openjdk.org/s/jdk-defer-pending)on a regular basis, several times per week. One of them will take one of the following actions:

- 
Approve the request by adding the label`jdk$N-defer-yes`. (There is no need to add a comment recording this approval.)

- 
Reject the request by adding the label`jdk$N-defer-no`, along with a comment describing the reason for this action.

- 
Request more information by adding the label`jdk$N-defer-nmi`(“`nmi`” = “needs more information”), along with a comment describing what information is requested.

In any case,**do not**remove the`jdk$N-defer-request`label.

JBS query for pending requests:`openjdk.org/s/jdk-defer-pending`](https://openjdk.org/s/jdk-defer-pending)

### Responding to actions taken on your deferral request

- 
If you’re asked to provide more information for a deferral request then please do so in a new comment in the issue, and then remove the`jdk$N-defer-nmi`label so that reviewers see that it’s ready for re-review.

- 
If your request is approved then no further action on your part is required.

## Fix-Request Process

This process applies fromRDP 2](#rdp-2)until the end of the release.

### Requesting approval to integrate a fix

Before you spend too much time on a fix for a P1 or P2 bug, seek advice from a Group or Area Lead, on an appropriate mailing list, to make sure that fixing the bug in this release is actually a reasonable idea.

When you are confident in your fix then update the relevant JBS issue to add a comment whose first line is “Fix Request”. (You need not wait for the fix itself to be approved for integration by appropriate Reviewers.) In that comment briefly describe why it’s important to fix this bug, explain the nature of the fix, estimate its risk, describe its test coverage, and indicate who has reviewed it. If you have a pull request or webrev for the fix then include a link to that in the comment; otherwise, attach the patch for the fix to the JBS issue. Add the label`jdk$N-fix-request`to the issue, substituting the actual release version number for`$N`.

Always add the comment and label to the main-line JBS issue; do not add them to a backport issue.

### Reviewing fix requests

TheArea Leads, relevant Group Leads, and the JDK Project Lead](https://openjdk.org/projects/jdk/leads)will review thepending fix requests](https://openjdk.org/s/jdk-fix-pending)on a regular basis, at least weekly to start and more frequently as we approach the GA date. In case of an urgent situation you are welcome to contact an appropriate reviewer directly in order to solicit a prompt review.

A reviewer will take one of the following actions:

- 
Approve the request by adding the label`jdk$N-fix-yes`, along with a comment recording their approval whose first line is “Fix request approved”.

- 
Reject the request by adding the label`jdk$N-fix-no`, along with a comment describing the reason for this action whose first line is “Fix request rejected”.

- 
Request more information by adding the label`jdk$N-fix-nmi`(“`nmi`” = “needs more information”), along with a comment describing what information is requested whose first line is “Fix request NMI”.

In any case,**do not**remove the original`jdk$N-fix-request`label.

JBS query for pending fix requests:`openjdk.org/s/jdk-fix-pending`](https://openjdk.org/s/jdk-fix-pending)

### Responding to actions taken on your fix request

- 
If you’re asked to provide more information for a fix request then please do so in a new comment in the issue, and then remove the`jdk$N-fix-nmi`label so that reviewers see that it’s ready for re-review.

- 
If your request is approved then proceed to complete the fix and integrate it.

- 
If your request is rejected then you may appeal that decision to the Project Lead.

In any case,**do not**remove the original`jdk$N-fix-request`label.

## Late-Enhancement Request Process

This process applies fromRDP 1](#rdp-1)until the end ofRDP 2](#rdp-2).

### Requesting approval for a late enhancement

If you wish to integrate an enhancement in RDP 1 or RDP 2 then you can request approval as follows: Update the relevant JBS issue to add a comment whose first line is “Late Enhancement Request”. In that comment describe the risk level, a brief justification that quotes actual developer feedback if possible, and your best estimate of the date by which you’ll integrate it. Add the label`jdk$N-enhancement-request`to the issue, substituting the actual release version number for`$N`.

Always add the comment and label to the main-line JBS issue; do not add them to a backport issue.

Enhancements to tests and documentation during RDP 1 and RDP 2 do not require approval, as long as the relevant issues are identified with a`noreg-self`or`noreg-doc`label](https://openjdk.org/guide/#noreg), as appropriate.

### Reviewing enhancement requests

The JDK Project Lead or a delegate, in case of absence, will review thepending enhancement requests](https://openjdk.org/s/jdk-enhancement-pending)on a regular basis, several times per week. They will take one of the following actions:

- 
Approve the request by adding the label`jdk$N-enhancement-yes`, along with a comment recording their approval whose first line is “Late enhancement approved”.

- 
Reject the request by adding the label`jdk$N-enhancement-no`, along with a comment describing the reason for this action whose first line is “Late enhancement rejected”.

- 
Request more information by adding the label`jdk$N-enhancement-nmi`(“`nmi`” = “needs more information”), along with a comment describing what information is requested.

In any case,**do not**remove the`jdk$N-enhancement-request`label.

JBS query for pending requests:`openjdk.org/s/jdk-enhancement-pending`](https://openjdk.org/s/jdk-enhancement-pending)

### Responding to actions taken on your enhancement request

- 
If you’re asked to provide more information for an enhancement request then please do so in a new comment in the issue, and then remove the`jdk$N-enhancement-nmi`label so that reviewers see that it’s ready for re-review.

- 
If your request is approved then update the issue’s due date to the expected completion date.

## History

- 
2023/6/1 — Revised to describe the stabilize-via-backports idiom adopted in JDK 21 (proposal](https://mail.openjdk.org/pipermail/jdk-dev/2023-April/007612.html)).

- 
2023/12/20 — Revised the integration instructions to advise the immediate creation of backport issues in order to avoid losing track of candidate bugs (proposal](https://mail.openjdk.org/pipermail/jdk-dev/2023-December/008560.html)).

- 
2024/12/1 — Replaced broken`j.mp`links with`openjdk.org/s`links.