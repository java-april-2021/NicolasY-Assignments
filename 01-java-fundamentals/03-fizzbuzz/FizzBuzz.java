public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0){
            return "FizzBuzz";
        } else if (number % 5 == 0){
            return "Buzz";
        } else if (number % 3 == 0){
            return "Fizz";
        } else {
            Integer.toString(number);
        }
    }

    public void FizzBuzzTester(){
        for (int i = 1; i <= 100; i++){
            String result = fizzBuzz(i);
            System.out.println("number " + i + " Result: " + result);
        }
    }
}
