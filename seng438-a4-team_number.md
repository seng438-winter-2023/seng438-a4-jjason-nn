**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:17    |     
| -------------- |
| Student Names: |    
| Ajay Arumugam  |     
| Haseeb Khan    |     
| Sadia Khandaker|
| Jason Nguyen   |

# Introduction

This lab consists of two sections: Mutation Testing and GUI Testing. Students will learn how to inject mutation faults into a Java code-base using a mutation testing tool, how to interpret the reported mutation scores, and how to apply this knowledge to the design of new test cases to improve the overall quality of the test suite during the first part of the course. The second section focuses on the most prevalent method of GUI test automation, record and replay. Students will learn how to utilize Selenium, a well-known web interface testing tool, and compare it to an alternative.

In Assignment 3, we investigated whitebox testing and various code coverage tools to enhance our designed test suites. Now, we use tutorial testing and automated GUI testing to discover ways to improve our tests further.

For mutation testing, we used Pitclipse which is an Eclipse IDE plugin that runs the pitest mutation test tool against our unit tests by seeding mutations into our code. If our unit tests are written well, then they should fail given a mutation and indicate that there is an issue. If the tests pass, then it is likely that the unit tests did not account for a specific case. 

For GUI testing, we primarily used the Selenium web-interface testing tool to test the Amazon website. Instead of futilely attempting to discover bugs in the website, we instead focused on testing typical user interactions as a means of familiarizing ourselves with automation testing. Our tests will run sequentially, and will rely on the state of the prior test to function properly.

# Analysis of 10 Mutants of the Range class 

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENIUM test case design process

The Selenium test case design process was commenced by meeting with the team and deciding what 8 functionalities of the application we need to test. We chose the following functionalities:
1. Login
2. Product Review
3. Browse Category
4. Logout
5. Signup
6. Shopping Cart
7. Wishlist
8. Search Item

After deciding the functionalities, we assigned two to each, and each member was responsible for first play testing the functionality. Through this we were able to find the different kinds of input that could result in a success or a failure in that functionality. We then designed a test case for each of those scenarios within a test suite for each functionality.

Here are the different test cases:
1. Login
   - Invalid Email
   - Invalid Password
   - Correct Email and Correct Password
2. Browse Category
   - Browse Books Categories
3. Logout
4. Product Review
   - Write and submit product review on latest order 
5. Sign up 
   - Email already in use
    - Passwords don’t match
6. Shopping Cart
    - Add item to cart
7. Wishlist
    - Add item to wishlist
8. Search

# Explain the use of assertions and checkpoints

Assertions and checkpoints are utilized in Selenium to ensure that the system behaves as intended. The test cases are validated by comparing inputs to the expected value. Assertions are used to validate the conditions that must be verified before proceeding to the next step of a test. If found to be false, the test case will be terminated, and the steps that follow will be skipped. Assertions are especially useful when testing websites to ensure that a specific input or element is correct. For example, if you want to load a new page, you may check to see whether a button has been pressed. In contrast to assertions, verification checkpoints do not cause the execution of a test case to be paused if a checkpoint fails. The failure has been logged, and the testing process will proceed as usual. As a result of this, checkpoints are utilized in order to carry out conditions the outcomes do not influence the statements that follow after them. It is also used to run the whole test scenario regardless of whether the checkpoint was successful or not. Checkpoints are a valuable tool for checking items on a web page, such as the page title, that are susceptible to change but have no influence on other website functionalities.

# How did you test each functionality with different test data?

When testing some of the functions, we used Selenium's ability to change the "Value" field after the test case had been recorded. This approach helped us test with varying data and ensure the desired behaviour of the test case.We also made multiple test cases for certain scenarios, like logging in with both correct and incorrect credentials, signing up with an email that is already in use and a password that does not match, etc., because each scenario led to different results. For instance, we tested the login and signup processes with invalid email and password combinations, as well as with an already-used email address and mismatched passwords, to ensure that the expected error messages were displayed. 

# Discuss advantages and disadvantages of Selenium vs. Sikulix

After testing out both applications, we noticed that Sikulix was a lot easier to set up compared to Selenium. The Selenium IDE UI was a little bit confusing at first and took a while to get used to. Also we noticed that Selenium is only used to test web applications, but Sikulix can be used to test web applications and desktop applications. Also when we were troubleshooting setup through Google searches, we found that Selenium has a lot more articles and a bigger community, whereas Sikulix has a much smaller developer base to answer questions. Overall, I would definitely use Selenium in the future, just because of its widespread popularity in testing web dev applications. 

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned


While the concept of mutation testing was initially foreign to the majority of us, we learned that it is a powerful and effective software testing tool. The result of mutation analysis provided us with insights into the strengths and weaknesses of our previous test cases and guided the development of additional test cases to enhance the test strength of our test suites.   While mutation testing has its advantages, we did run across a few difficulties. Using the Pitest Eclipse plugin, in particular, we discovered that it can be a time-consuming, tedious, and computationally expensive process. This resulted in more time being spent on analysis and increased the overall testing time. Furthermore, we ran into a number of issues while using Selenium to test the GUI that made the process more challenging overall. The extension kept crashing, which made it difficult for us to save the testing script. This was the main issue we ran into. Due to this problem, we had to restart the browser and the extension frequently, which slowed down the testing process.


# Comments/feedback on the lab itself

Overall the lab was very useful to fully understand the concept of Mutation Testing and GUI testing. Selenium is a very popular tool in the industry for GUI testing, so I’m glad I was able to get experience with it through this lab. One of the links for the Selenium setup was not working. However, we got around it by following some external links on selenium. Overall, I would highly recommend using this lab for next year's class as well.
