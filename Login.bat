echo "starting script runner Login.feature"
mvn test -Dcucumber.filter.tags="@Login"
echo "ending script runner Login.feature"