import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public static void main (String[] args){
        String[] names = { "Nancy", "Jinchi", "Fujibayashi", "Momochi", "Ishikawa" }
        int[] nums = {3,5,1,2,7,9,8,13,25,32};

        Alphabet();
    }

    public static Character[] alphabet = {
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    }

    //return an array that only inlcudes numbers > 10
    public static int[] ArrayPuzzle(int[] numbers) {
		int sum = Basics.GetArraySum(numbers);
		System.out.println(sum + " is the sum of all the numbers in the array!");
		int[] bigArr = new int[Basics.GreaterThanY(numbers, 10)];
		int j = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 10) {
				bigArr[j] = numbers[i];
				j++;
			}
		}
		return bigArr;
    }

    //shuffle the array and print the name of each person
    //have the method also return an array with names that are longer than 5 characters

	public static void shuffeArray(Object[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length/2; i++) {
			Object temp = arr[i];
			int randomIdx = r.nextInt(arr.length - i) + i;
			arr[i] = arr[randomIdx];
			arr[randomIdx] = temp;
		}
	}

    //create an array of the alphabet
    //shuffle the array then display last letter of array and first letter (if a vowel display a message)

    public static void AlphabetPuzzle() {
		shuffeArray(alphabet);
		System.out.println(String.format("%s is first", alphabet[0]));
		System.out.println(String.format("%s is last", alphabet[25]));
		if(isVowel(alphabet[0]))
			System.out.println("Hey its a vowel");
	}
    private static boolean isVowel(char letter) {
		Random r = new Random();
		return (
			letter == 'a' ||
			letter == 'e' ||
			letter == 'i' ||
			letter == 'o' ||
			letter == 'u' ||
			// y is sometimes a vowel lol
			(letter == 'y' && r.nextInt(2) == 1)
			);
	}

    //Generate and return an array with 10 random numbers between 55-100.
    public static int[] RandomIntArray(int lowerBound, int upperBound) {
        int[] arr = new int[10];
        int offset = upperBound - lowerBound;
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(offset) + lowerBound;
        }
        Arrays.sort(arr);
        return arr; 
    }

    //Create a random string that is 5 characters long
    //Generate an array with 10 random strings that are each 5 characters long
    public static String[] RandomStringArr() {
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = StringManipulator.RandomString(5);
        return arr;
    }
}