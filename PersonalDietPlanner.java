import java.util.Scanner;
public class PersonalDietPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Your Name : ");
        String Name = input.nextLine();

        System.out.print("Enter Your Gender : ");
        String Gender = input.nextLine().trim().toLowerCase();

        System.out.print("Enter Your Age : ");
        int Age = input.nextInt();

        System.out.print("Enter Your Height [Cm] : ");
        double Height = input.nextDouble();

        System.out.print("Enter Your Weight [Kg] : ");
        double Weight = input.nextDouble();

        System.out.println("Select Your Physical Activity Level In A Scale Of 1-5 Mentioned Below ");
        System.out.println("1 = Sedentary");
        System.out.println("2 = Lightly active");
        System.out.println("3 = Moderately active");
        System.out.println("4 = Active");
        System.out.println("5 = Very active");
        System.out.println();
        System.out.print("Enter : ");
        int Activity = input.nextInt();
        //for space purpose
        System.out.println( );

        double ActiveLevel = ActiveLevelCounter(Activity);

        //BMI value to find the weight level /  body condition
        double BMI = Double.parseDouble(BMIcalculator(Height, Weight));

        //here we store calories count for the Macros ratio ,weight maintain, weight gain or weight loss
        int CalorieCount = Calories(Gender, Age, Height, Weight, ActiveLevel);

        //Final Diet Plan
        DietPlanner(Name,CalorieCount,BMI);


        input.close();

    }

    private static double ActiveLevelCounter(int Activity) {

        //Here we are finding the physical intensity level of the user
        //Counter for the multiplication in the calorie section
        //if we enter the number other than 1-5 it counts the counter value as 1
        double Counter =1;

        if ( Activity == 1) {
            //Activity level is sedentary
             Counter = 1.2;
        } else if (Activity == 2) {
            //Activity level is lightly active
             Counter = 1.375;
        } else if (Activity == 3) {
            //Activity level is moderately active
             Counter = 1.55;
        } else if (Activity == 4) {
            //Activity level is  active
             Counter = 1.725;
        } else if (Activity == 5) {
            //Activity level is very active
             Counter = 1.9;
        }
        return Counter;


    }

    static String BMIcalculator(double Height, double Weight) {

        double BMIValue = Weight / (Height * Height) * 10000;

        String BMIFinal = String.format("%.2f", BMIValue);
        return BMIFinal;

    }

    static int Calories(String Gender, int Age, double Height, double Weight, double ActiveLevel) {


            if (Gender.equals("male")) {

                //                System.out.println("Your Maintenance Calories = "+Calories);

                return (int) ((10 * Weight + 6.25 * Height - (5 * Age) + 5) * ActiveLevel);

            } else if (Gender.equals("female")) {

                //                System.out.println("Your Maintenance Calories = "+Calories);

                return (int) ((10 * Weight + 6.25 * Height - (5 * Age) - 161) * ActiveLevel);

            } else {
                System.out.println("Invalid gender input !");
                return -1;
            }

        }static void DietPlanner(String Name , int CalorieCount , double BMI){

        System.out.println("Hi "+Name+" Here Is Your Diet Planner ");
        System.out.println();
        System.out.println("Your Daily Required Calories "+CalorieCount);
        System.out.println();

        System.out.println("Your Daily Diet Plan ");
        System.out.println();
        System.out.println();
        //Here we are printing the maintenance calorie statement every time
        System.out.println("Required Calorie To Maintain Present Weight : "+ CalorieCount + " Calories Per Day");
        System.out.println();

        //now we are calculating ratio / percentage for macros

        //for carbohydrates
        //Here we are dividing by 4 because 1 gm of carbs gives 4 calories
        double MinCarbs = ((CalorieCount*0.55)/4);
        String Carbs55 = String.format("%.2f", MinCarbs);
        double MaxCarbs = ((CalorieCount*0.60)/4);
        String Carbs60 = String.format("%.2f", MaxCarbs);

        System.out.println("Carbohydrates (Grams) portion in your diet : "+Carbs55+" - "+Carbs60+" Grams");
        System.out.println();

        //for protein
        //Here we are dividing by 4 because 1 gm of protein gives 4 calories
        double MinProtein = ((CalorieCount*0.25)/4);
        String Protein25 = String.format("%.2f", MinProtein);
        double MaxProtein = ((CalorieCount*0.30)/4);
        String Protein30 = String.format("%.2f", MaxProtein);

        System.out.println("Protein (Grams) portion in your diet : "+Protein25+" - "+Protein30+" Grams");
        System.out.println();

        //for fats
        //Here we are dividing by 9 because 1 gm of fat gives 9 calories
        double MinFats = ((CalorieCount*0.15)/9);
        String Fats15 = String.format("%.2f", MinFats);
        double MaxFats = ((CalorieCount*0.20)/9);
        String Fats20 = String.format("%.2f", MaxFats);

        System.out.println("Fats (Grams) portion in your diet : "+Fats15+" - "+Fats20+" Grams");
        System.out.println();
        System.out.println();


        //Here I am declaring the calories. so ,I can easily add their variable names in the print statement line
        //calories for weight loss
        int MildWeightLossCalories = CalorieCount-250;
        int WeightLossCalories = CalorieCount-500;
        int ExtremeWeightLossCalories = CalorieCount-1000;

        //calories for weight gain
        int MildWeightGainCalories = CalorieCount+250;
        int WeightGainCalories = CalorieCount+500;
        int FastWeightGainCalories = CalorieCount+1000;



        System.out.println("Normal Weight BMI Range 18.5 - 24.9 ");
        System.out.println("Your BMI Value : "+BMI);
        System.out.println();

        if (BMI < 18.5) {

            System.out.println("You Are Under Weight.");
            System.out.println("You Need To Gain Weight ");
            System.out.println();
            System.out.println("We recommend below plans for you");

            System.out.println("Required Calorie To Mild Weight Gain (0.25Kg/Week) : "+ MildWeightGainCalories + " Calories Per Day");
            System.out.println("Required Calorie To Weight Gain (0.5Kg/Week) : "+ WeightGainCalories + " Calories Per Day");
            System.out.println("Required Calorie To Fast Weight Gain (1Kg/Week) : "+ FastWeightGainCalories + " Calories Per Day");


        } else if (BMI >= 18.5 && BMI < 25) {

            System.out.println("You Are Normal Weight.");
            System.out.println("You are maintaining healthy weight , Keep going");
            System.out.println();
            System.out.println("We recommend below plans for you");

            System.out.println("Required Calorie To Mild Weight Gain (0.25Kg/Week) : "+ MildWeightGainCalories + " Calories Per Day");
            System.out.println("Required Calorie To Weight Gain (0.5Kg/Week) : "+ WeightGainCalories + " Calories Per Day");
            System.out.println("Required Calorie To Fast Weight Gain (1Kg/Week) : "+ FastWeightGainCalories + " Calories Per Day");


        } else if (BMI >= 25 && BMI < 30) {

            System.out.println("You Are Over Weight.");
            System.out.println("You Need To Loose Weight ");
            System.out.println();
            System.out.println("We recommend below plans for you");

            System.out.println("Required Calorie To Mild Weight Loss (0.25Kg/Week) : "+ MildWeightLossCalories + " Calories Per Day");
            System.out.println("Required Calorie To Weight Loss (0.5Kg/Week) : "+ WeightLossCalories + " Calories Per Day");
            System.out.println("Required Calorie To Extreme Weight Loss (1Kg/Week) : "+ ExtremeWeightLossCalories + " Calories Per Day");


        } else {
            System.out.println("You Are Obese.");
            System.out.println("You Need To Loose Huge Weight ");
            System.out.println();
            System.out.println("We recommend below plans for you");

            System.out.println("Required Calorie To Mild Weight Loss (0.25Kg/Week) : "+ MildWeightLossCalories + "Calories Per Day");
            System.out.println("Required Calorie To Weight Loss (0.5Kg/Week) : "+ WeightLossCalories + "Calories Per Day");
            System.out.println("Required Calorie To Extreme Weight Loss (1Kg/Week) : "+ ExtremeWeightLossCalories + "Calories Per Day");



        }

            System.out.println();
            System.out.println("Stay Hydrated , Hit Gym , All The Best");
            System.out.println();
            System.out.println("Thank You..");

    }


    }


