echo "starting script runner Login.feature"
set projectpath=./EmobiAPIs_Automation/src/test/java/emobi/runner
cd %projectpath%
call mvn test -Dcucumber.filter.tags="@Login"
echo on
cd %projectpath%
call mvn exec:java
echo on
pause