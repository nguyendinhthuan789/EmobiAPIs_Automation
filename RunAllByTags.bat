echo "starting script runner api partner"
mvn test -Dcucumber.filter.tags="@C2s_BA or @Mo_AT or @PinRequest_RS or @PinVerify_RS"
echo "ending script runner api partner"