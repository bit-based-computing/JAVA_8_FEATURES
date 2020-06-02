package lambdaExpression;

@FunctionalInterface
interface Filter {
     boolean match(Person person) ;
}
