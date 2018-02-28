
# Report for assignment 4
## Project
Name: Bt 
URL: https://github.com/atomashpolskiy/bt 
A bitTorrent client that is implemented in Java 8 that can be run through the command line. 
## Complexity

### 1. What are your results? Did everyone get the same result? Is there something that is unclear? If you have a tool, is its result the same as yours?
Functions that we manually inspected:

##### Function 1: ReadWriteDataRange::getSubRange(long offset, long length):
Benjamin count: 17 (initially used another definition)

Rami count: 11

Lizard count: 17

Anton count: 11

##### Function 2: MetadataService::buildTorrent(BEParser parser):
Benjamin count: 16

Rami count: 16

Lizard count: 22

##### Function 3: ByteChannelReader::sync(ByteBuffer buf, byte[] syncToken):
Benjamin count: 10 

Rami count: 10

Lizard count: 17

##### Function 4: MessagingAgentCompiler::compileType(Class<?> type Collection<ConsumerInfo> consumersAcc, Collection<ProducerInfo> producerAcc):
Anton count: 11
  
Benjamin count: 11
  
Rami count: 11

Lizard count: 17

##### Function 5: Tokenizer::tokenize():
Anton count: 17

Benjamin count: 17

Rami count: 17

Lizard count: 19


When calculating the CCN, we used the formula M = 𝝅 - s + 2, where 𝝅 is the number of conditional statements and s is the number of ending statements. The only exception to this is when Benjamin used another formula found on the web that said M = P + 1, where P is every predicate node. The second formula may be the technique that is used by Lizard when evaluating the CC, which is probably why our results differ from Lizard’s results. 
### 2. Are the functions/methods with high CC also very long?
We have noticed some correlation between the CC and the length of the functions; they are definitely longer than simpler functions. While there isn’t a direct correspondence, in most cases the functions with the highest CCN is also the ones with the most LOC. However, if we take function Tokenizer::tokenize() as an example, it had a CCN of 17 (or 19 according to Lizard), but only had about 50 LOC. The prime tell of CC is to look for a large amount of conditionals (of course, if the functions are longer, then there is a greater chance of conditionals showing up). 

### 3. What is the purpose of these functions? Is it related to the high CC?
These were the 10 functions which cyclomatic complexity we inspected with the lizard tool:

##### Function 1: ReadWriteDataRange::getSubRange(long offset, long length):
This method returns a subrange of the data range, which is a “map” of offsets to binary data in torrent files. The subrange starts from the specified offset from the data range and ends at offset + length.   
The complexity seem to come from the fact that whenever it has remaining bytes in the subrange, it adds the size of the whole file to the subrange and then at the end it checks and removes any excessive part of the subrange. It also contains many conditions that would lead to thrown exceptions. Looking at it briefly, there seems to be some excessive conditional checks. 

##### Function 2: MetadataService::buildTorrent(BEParser parser):
Builds a torrent object by creating it and then setting all its properties if they can be set.
Some of the complexity comes from unnecessary input-checks, but mostly it just has a lot of stuff to set, so the method needs most of its complexity. However, it could easily have been split up into smaller methods for each property to increase readability.

##### Function 3: ByteChannelReader::sync(ByteBuffer buf, byte[] syncToken):
The method reads bytes from a readable data channel and stores it in a byte buffer buf. For every read instruction, it waits a certain amount of time before the next read iteration. The function returns the amount of bytes that were read. 
The functionality here seems to be inherently complicated, as it needs to ensure that it doesn’t read too many or to few bytes (the class has defined limits for how much or how little is allowed to read) and also have to synchronize itself so it reads every X amount of milliseconds. It also has exception checks to see that the reading doesn’t go beyond the buffer limit and also checks to see that it gets any data at all, which are necessary to ensure correctness.  It is uncertain if any complexity can be removed here (although that may be due to the method being hard to understand, there is no documentation). 

##### Function 4: MessagingAgentCompiler::compileType(Class<?> type Collection<ConsumerInfo> consumersAcc, Collection<ProducerInfo> producerAcc):
This method recursively counts the number of consumer- and producer-methods found in the given object and its super-classes.
Some of the complexity comes from it checking if it should log debug-messages or not, and also it is testing so that the given object and its super-classes adhere to the restrictions set by the library.

##### Function 5: Tokenizer::tokenize():
Reads from a buffer and generates a list of tokens based on its content. The complexity is not needed in this case. Most of it comes from the different cases in the switch-statement. This makes sense, but it has different states for every number (0-9) that all execute the same code. Using an if-statement with a range would remove almost 50% of the complexity and still yield the same result.
Some complexity could also be removed if the error checking was performed by a separate method. Currently this method also checks that the buffer is in a valid state.

##### Function 6: BtRuntimeBuilder::createInjector():
This method creates an Injector object that is used by the BtRuntimeBuilder. The Injector object is a tool that is used as an object-graph builder i.e it keeps track of dependencies between object types and uses dependency bindings to inject them. 
The task itself seem to be pretty straightforward, create an Injector based on module objects (Modules are collections of dependency bindings for types). The complexity in this function comes from that it needs to check the condition of several flags to know what kind of modules that needs to be included when creating the Injector. There are also some conditional statements that are solely for checking what information that should be logged, which is arguably not part of the task itself. 

##### Function 7: TorrentDumper::dumpStats():
This method iterates through all the items, removes the .torrent file for the current item if present. If not present then it is added to the workset to dump the stats for. Iterates through the workset and check for existing dump stats file. If it is present it updates the information present in the dump in internal memory variables and then finally creates a temp file and dumps this information and then puts it in place of the actual stats file.
The tasks accomplished in this method are pretty straight forward yet a few conditional statements can be removed as they are implicit and they are always evaluated to true at that point of the execution of the program. But this will not result in a considerable reduction of CCN.

##### Function 8: Assignments::update():
This method iterates through a set of peers and first check if the underlying conditions for assignments are still true. The input parameters are two sets: “ready” and “choking”. It first creates a new set ,”readyPeers”, with the elements in ready and iterates through those. If some of the conditions fail then that peer is removed from readyPeers. It then iterates through the original ready set and if any element is missing in readyPeers or if a value in an element is empty then it is removed from ready. Finally the peers in choking are added to ready if they fulfill the condition in function “Assignments::hasInterestingPieces(Peer peer)”. Finally it returns the updated ready set.
Most of the conditions are probably necessary based on underlying structures but there is at least one if statement that you should be able to remove since the condition is always false.

##### Function 9: GetLookupTask::callFinished(RPCCall c, MessageBase rsp):
This method takes care of the routine to be performed after the call is finished. In this method the signature of the rsp is checked. If it is a mismatch, it does not perform any operation and makes sure there is no side effects , if it matched then it adds the candidates and the nodes that are returned in the rsp.
The task in itself needs many base conditions to be satisfied and thus we need to check for them before proceeding and causing any side effect. The high CCN could be justified with the complexity of the task at hand in this case.

##### Function 10: Assignments::assign(Peer peer):
This method checks the list of pieces (collections of data) and tries to assign a piece to the peer that is specified at input. 
The task itself isn’t too complex, but this method introduces some unnecessary complexity. An example of this is that when the method iterates through every piece, it check if the piece is completed. If that is the case, then it removes the piece from the list and then continues checking. This task is not really part of the method task and could be sectioned off as a separate method.  

### 4. If your programming language uses exceptions: Are they taken into account in the CC count? If you think of an exception as another possible branch (to the catch block or the end of the function), how is the CC affected?
When we calculated the CC by hand, we took the exceptions into account as a possible branch path. We are not really sure how Lizard deals with exceptions when it counts the CC number, but we believe that it may count every try-catch as added complexity, but doesn’t subtract when exception is thrown in catch statements (which we did, as it counts as an exit statement). 

### 5. Is the documentation of the function clear about the different possible outcomes induced by different branches taken?
Throughout the project, there are not that many comments in the code and very few of them actually documents anything about possible outcomes and branches. Most of the time, different branches are not highlighted in any form of documentation, you have to look at the code itself to get that information.

## Coverage
### Tools
For this assignment, we used OpenClover as a way to measure the coverage of the different methods. The reason we chose this tool was because it integrates well with eclipse, which we used during the project. This made it easy to integrate with the build environment, we just had to follow the instructions on their webpage to install the plugin to eclipse. 
The tool was also quite simple to use as well. After a little bit of playing around with OpenClover, we found it quite intuitive to use when it comes to measuring coverage and how often a branch inside a function is taken. There was also some documentation on their website regarding different features, so there weren’t many problems with using the tool. Overall, the experience with using OpenClover was without any major complications.
The manually implemented coverage tool is described in more detail in the next section. 
### DYI
Link to patch:
https://github.com/rka0917/bt/compare/master...rka0917:manual-coverage-check

The tool: https://github.com/nreje/CodeCoverage

The tool works as follows: You create a CodeCoverage object before the branch testing begins. The idea was to create said object in a test suite / in the test methods and capture the System.out.println(string) calls where the string begins with “#CC#” and collect them in a set. The strings will beside “#CC#” also contain something that identifies the branch/line of code. When all method calls for some method you want to check the coverage for is done you either call the getResult() method or writeToFile() method to get the content of the set, which would be information on the branches covered.
However, because of the nature of the tests available, most of which were integration tests and very few unit tests for the methods we were interested in, we had to put the CodeCoverage object in the methods we wanted to test themselves. This means that instead of getting one nice set at the end with all the information on branch coverage we instead get on file with the branch information for every call of the method which sometimes could be in the hundreds.
Since all that is required for the tool to work is the ability to write a System.out.println most situations aren’t too difficult to deal with. If and else statements are very easy: Just add the println within them. For while loops and for loops we add one println inside the loop and one after the loop. For exceptions we add the println inside the catch block or before the throw. For ternary operators we create an if else statement with the same condition and write the println inside that.

The result is that it will either output the branch coverage into a file or return the set for you to handle however you wish. 
## Improvement of Coverage
Report of old coverage: https://rka0917.github.io/Assignment4pages/PRE/dashboard.html 

Report of new coverage: https://rka0917.github.io/Assignment4pages/POST/dashboard.html 

##### Methods in which test coverage was extended:
- MSEHandshakeProcessorTest::negotiateIncoming(Peer peer, ByteChannel channel, ByteBuffer in, ByteBuffer out) in package bt.net.crypto 
- ByteChannelReader::sync() in package bt.net
- Assignments::update(Set<Peer> ready, Set<Peer> choking) in package bt.torrent.messaging
- Assignments::assign(Peer peer) in package bt.torrent.messaging
- ReadWriteDataRange::getSubrange(long offset, long length) in package bt.data

Link to branch with added test cases:
https://github.com/rka0917/bt/compare/master...rka0917:extend-test-coverage
## Refactoring
In this section, we describe five different functions, specifically how they can branch and how we envision that they can be refactored. 

#### Tokenizer::tokenize()
##### Branch
Tokenize goes through an internal byte-buffer and looks for predefined byte-values and generates a list of tokens. For each recognized byte, the method will append a token to the list, while if an unrecognized byte is found it will throw an exception.

Tokenize takes no parameters and doesn’t return anything. Instead it modifies the internal state of the object. This makes it somewhat hard to test.

The reason behind the high CCN-count is that it contains a switch-statement that lists all the recognized byte-values. It is actually a very simple method which only contains 2 if-statements and a while-statement, but because of its switch it gets an unfortunately high CCN. The while-loop loops through every byte in the buffer and is inherently necessary, one if-statement is for error-checking and one checks so that we haven’t gone through the entire buffer yet.

##### Refactor
If you were to perform checks upon adding bytes to the buffer you could omit the two if-statements. This would only move the complexity elsewhere, but it may be better suited there regardless.

The main refactoring however would be to rewrite the switch-statement using if and else ifs since these allow checking for ranges. Currently the switch has a separate case for all bytes 0-9, which all take the same action afterwards. These cases could be written as one if-statement like this: 0 <= b && b <= 9. Using if-statements, you also don’t need to have the default which currently checks for unrecognized bytes. This part should only be left out if the checks are already done elsewhere however.

By just switching out the switch-case to if-statements would yield a CCN of 9. Seeing how it was 17 before, this is a decrease of about 47%.

#### Assignments::update(Set<Peer> ready, Set<Peer> choking)
##### Branch
The purpose of this function is to update the list of peers for assignments.
There are two parameters; ready and choking which are both sets of peers. Depending on the content of those two you can get some different internal results and a different final result set.

If ready is empty then the first part of the function is skipped and the second part would then remove all the entries in the internal peers set. The third part doesn’t involve the ready set directly but by that point ready and the peers set should be identical and since they both are empty now nothing much happens there either and you get an empty set back.
If choking is empty then everything is done except the final third part since that is the only part that involves the choking set. You will get the entries in the ready set then as the returned set.

There is also some potential differences that stem from the state of the bitfields associated with the peers in ready and choking when it comes to removing and adding peers to the peers set and to the final result set. Something that also influence are the queues that are linked with peers in the peers set.

If any peer in ready lacks a bitfield then it is ignored and potentially removed depending on the state of the peers set. If none of the pieces are verified in the bitfield then the peer will not be added to peers. If one or more pieces are verified however, then it will be added to the peers set with an empty queue if it didn’t exist before and add the piece(s) to the queue or it will just add the piece(s) to the already existent queue. If the queue gets to big though, it will be ignored for the rest of the iteration.

If the peers in the peers set are not in the ready set anymore or if the queues are empty then those entries are removed from peers. Finally, if the bitfield of any peer in choking do not have any pieces that the local bitfield don’t have then they are not included in the result set.

##### Refactor
This function has a pretty easy refactoring that can be done. There is an if check in the early part of the method that the queues are not too large which can never be fulfilled and the code inside the block is therefore dead code. This happens because in a later part of the method there is a point where queues can be increased but right after there is a check that makes sure that the queue isn’t to big or it’s removed. Because of that no queue can ever exist that are caught by that first check because every queue that was too large will already have been dealt with by the other check.

There might be a potential refactoring available but it depends a lot on some unknown underlying structures. There is a bit of a mystery as to what differentiates the two sets “ready” and “choking” but something that definitely could be done is to remove the last part of the method where the peers in choking are added to the returned set since that operation is a bit disjoint from the rest of the method.

If you have some more information on choking and ready however, you might be able to accomplish a bit more, like maybe separating the choking from update entirely but that is a bit difficult right now.

#### Assignments::update(Peer peer)
##### Branch
This method takes a peer and then goes through the collection of existing pieces and tries to assign a piece that has not been assigned to another peer. 

This method has two major branches depending on the state of the collection of pieces. If all of the remaining pieces have been requested, then the state has entered “endgame” mode. During this state, the function will just randomly pick a piece and assign it to the peer. 

If it hasn’t hit endgame mode, then it will be a little bit more involved. It instead iterates through every piece until it has either found an unassigned piece or it has iterated through all pieces. For every iteration it also checks if the piece has been completed. If this is evaluated to true, it will lead to a branch where the piece is removed from the collection (locally). The loop also contains some other branches, where if the conditions are satisfied, the function will write to the logger. After the loop iteration, if an unassigned piece has been found, then it will lead to branch where a piece to be assigned is returned, otherwise an empty Optional instance will be returned.  

In the beginning, there is also a branch that returns an empty Optional instance is returned, which is reached when there is no pieces in the collection (or if the collection doesn’t exist).

##### Refactor
Most of the complexity for this function lies in the do-while loop that goes through every piece and checks if it is assigned. There isn’t much that needs to be refactored here, as many of the branches are related to the logging. However, one thing that could be done is to move the a section to its own function. As stated, the function removes a piece from the collection if it finds out that it is completed. However, this functionality isn’t strictly related to the functionality of the function, as the task of the function is to find and assign a unassigned piece to a peer. Therefore, the removal of pieces could possibly be moved somewhere else, or at the very least be put in its own function so it is easier to distinguish from the other task of the function.

Another thing that could be changed is that after the iteration, there are several conditionals which checks the status of a boolean variable called assigned. These could be put into one single conditional that checks the condition of the boolean variable. 

#### MSEHandshakeProcessorTest::negotiateIncoming(Peer peer, ByteChannel channel, ByteBuffer in, ByteBuffer out)
##### Branch
The purpose of this method is to exchange keys and encryption.
It has 3 possible outcomes. Either an exception if some conditions are not met (like a too large padding, an unsupported torrent request or an unknown encryption policy) or an Optional.empty if we don’t want to encrypt or finally an optional containing the cypher if we met all the conditions and we want the encryption

##### Refactor
This function is already pretty well modularized (for example by xor, getPadding, selectPolicy) so it would be hard to split the code more efficiently. But we can refactor this function by removing dead code. For example when we are checking the EncryptionPolicy, we check if we have an encryption policy that is not contained in the enum. But in fact we cannot have other cases that the cases in the enum. Otherwise an exception will be thrown before reaching the check. There is other examples when a condition is test two times. One in the main method, the other one, in a function called just before or handled by the constructor. For example, testing msedisable is useless in negotiateIncoming because the constructor will call MSEKeyPairGenerator, resulting in a exception if msedisable is true.

#### ReadWriteDataRange::getSubrange(long offset, long length)
##### Branch
This method is used to retrieve the subrange of units (virtual addresses) from ReadWriteDataRange which is a map of all the available storage units, from the given offset until the length specified in the input.
It has 2 possible outcomes. Either an exception if some of the pre-conditions are not satisfied (input parameter validation) or another ReadWriteDataRange with the subRange that satisfies the input criteria. This function has a high value of CCN because of the fact that it needs to check a lot of pre-conditions and sanity checks of variables while processing them.

##### Refactor
The function in itself needs most of the conditional statements, and it does the bare minimum of what that particular function is supposed to do. Even though there is not much space for refactoring a good amount of code , there is one particular conditional statement that is unnecessary. In which the if statement inside a loop will always evaluate to true only in the first iteration. It need not be present inside the loop , as it will happen only once at first , so we don't even need to check for that condition as the previous assignment makes sure that it is always true. Thus moving it out of the loop will remove the branches and makes it more streamlined thereby resulting in reduction in the CCN. Other conditional statements could be easily explained with the logic behind the implementation and it eliminates the need for refactoring it.


In general, we discovered that for some of the function, they could be split up into smaller functions to create a boundary between subtasks within function, which can reduce the cyclomatic complexity of the function. One thing that is noteworthy is that the project deals with the peer-to-peer domain, which means that there is a lot of checks to validate the current state of the p2p status (e.g when assigning pieces in Assignments::assign()). These check might in many cases be necessary to ensure correctness and cannot be reduced easily. 

## Effort spent
For each team member, how much time was spent in
##### 1.  plenary discussions/meetings;

Anton - 

Benjamin - 

Ganesh - 

Niklas -

Rami - 
##### 2.  discussions within parts of the group;
Anton - 

Benjamin - 

Ganesh - 

Niklas -

Rami - 
##### 3.  reading documentation;
Anton - 

Benjamin - 

Ganesh - 

Niklas -

Rami - 
##### 4.  configuration;
Anton - 

Benjamin - 

Ganesh - 

Niklas - 

Rami - 
##### 5.  analyzing code/output;
Anton - 

Benjamin - 

Ganesh - 

Niklas - 

Rami - 
##### 6.  writing documentation;
Anton - 

Benjamin - 

Ganesh - 

Niklas -

Rami - 
##### 7.  writing code;
Anton - 

Benjamin - 

Ganesh - 

Niklas - 

Rami - 
##### 8.  running code?
Anton - 

Benjamin - 

Ganesh - 

Niklas - 

Rami - 
## Overall experience
One of the main takeaways from this project was a perspective on how to look at code complexity. During the first part of the assignment when we had to calculate the cyclomatic complexity of different functions, we got some firsthand experience in how CCN can be used as a way to measure the complexity of a function. We found it to work quite well generally and in many cases, it seemed like it corresponded with lines of code (although not all of them). However, we also realise that it isn’t perfect and in some cases, it can be misrepresentative of how complex a function actually is. The most prominent example that we could find with this was when there was a function with many if-statements that were isolated and not nested within each other. The cyclomatic complexity number was high because of the number of if/while-statements, but because they weren’t nested within each other meant that the method seemed more complex than what it actually was. Generally though, we found that the lower the CCN was, the easier it was to follow the code.

It was also good that we got to work with a coverage tool. Many of us in the group had never worked with one before and overall, it was a useful experience. The fact that we also had to manually create a simple coverage tool also made it easier to get an insight in how they might work. This knowledge might be useful to us in the future whenever we need to test software in the future. 

Finally, we also learnt that it may be most efficient to create unit tests while you are writing the code, instead of skipping it or doing it later. Unit tests are necessary to get good coverage when creating new modules, but can be harder to implement later in development. In our project, there were some methods that did not have unit tests implemented, so we had to create them. This wasn’t always easy, as it meant that we had to understand the code and requirements, which weren’t always clear as documentation didn’t exist for everything in the code.

One big problem that we encountered during this project was that there was a big part of the project that we could not test or execute. For some reason, it would not show up on eclipse’s package explorer and we could not run the test cases. There was unfortunately no documentation that could help us in this regard, which meant that we had to ignore this part of the program. This was a huge loss, as many (if not most) of the most complex function resides in this part. 
