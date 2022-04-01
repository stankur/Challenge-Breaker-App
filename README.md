# Challenge Breaker

## Break down your challenges!


We humans love solving challenges. It is how we progress. Solving our own challenges teaches us an 
important knowledge; the knowledge that we are equipped to fight the things we fear. It gives us 
courage to walk into the dark with trust in perseverance. 

***How do we tackle challenges?***

- if we are sure that we are equipped to solve the challenge, we 
immediately solve it.

- if the challenge seems too big, we break them down into smaller
pieces

This project aims to help users break down their challenges into smaller
and more manageable pieces which we call "mini elaborated challenges" which each could be
treated and interpreted as a challenge.

What you'll be able to do with **Challenge Breaker**:

**General**

- step into existing challenges and view their elaborated mini challenges
- step out of a challenge until outermost layer
- add more elaborated mini challenges to existing challenges
- remove existing challenges
- update name and description of existing challenges
- switch order of mini elaborated challenges
- track challenge completion by checking and unchecking challenges

**Persistence**
- save state of current challenge anytime you want
- be reminded to save the state of current challenge when quitting
- load previous challenge anytime you want

***Phase 4: Task 2***

Added Challenge hihi to mini elaborated challenges Challenges Group of lols
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge lols to mini elaborated challenges Challenges Group of test challenge
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge test challenge to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge testchallenge 1 to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge test challenge 2 to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge heheh to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:55 PDT 2022

Added Challenge new one to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:55 PDT 2022

Removed Challenge test challenge from mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:56 PDT 2022

Removed Challenge testchallenge 1 from mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:31:58 PDT 2022

Removed Challenge test challenge 2 from mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:32:00 PDT 2022

Added Challenge test add to mini elaborated challenges Challenges Group of root
at time: Fri Apr 01 15:32:24 PDT 2022


Process finished with exit code 0

***Phase 4: Task 3***

Looking at my UML diagram, I feel like there lots of reused way of structuring things
in my code that I would want to abstract away if I had enough time. For example,
I used the same FormattingData object for a lot of
my components in my ui. Looking at the Singleton design pattern
in EventLog, I think FormattingData in my code would be a pretty good place to apply the singleton
design pattern since there is only one instance of it throughout the whole
program.

There are also inconsistencies in how I divided my packages. for example, I have multiple buttons packages various 
places in my program, but I do not have a single package which holds all the possible buttons to be used in the program.
I think I would add all the buttons available into a package to help people who read my code understand the program 
better.

I would also want to improve the naming of various packages since right now, i think some package names don't really 
reflect to a full extent of the classes they contain. 
