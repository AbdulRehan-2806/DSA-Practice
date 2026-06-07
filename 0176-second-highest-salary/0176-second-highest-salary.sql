# Write your MySQL query statement below
Select (
    Select DISTINCT salary
From Employee 
Order By salary DESC
Limit 1 OFFSET 1) as SecondHighestSalary;