CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
    --   Select (
    --     Select salary from Employee e1 
    --     Where N >= (Select count(distinct salary) from Employee e2 Where e2.salary >= e1.salary)
    --   )
    Select DISTINCT(salary) from Employee e
    Order By salary DESC 
    LIMIT 1 OFFSET N
  );
END