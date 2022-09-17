# Rest Application Template
Architectural template for building a structured application.
## Description
We all often encounter the "spaghetti" effect on large Java projects at the late stages of the application lifecycle,
what is the way out in this situation? As the classics teach, splitting the application into levels (structuring), building
a logical model with well-developed functionality and the closest approximation to the principles of OOP, should solve this problem.
The proposed template provides sufficient insight to understand this approach. The proposed approach is not without flaws,
for example, noticeable redundancy of the code when implementing data transfer objects and converting them, or duplication
code at different levels, but this is the necessary fee that has to be paid with this approach to building an application.
One of the most important conditions is the separation of business logic into a separate level and the requirement
to avoid the implementation of business logic at the service level. I hope this example will help you in solving your problems.


