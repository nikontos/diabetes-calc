package sample;

public class variables {

    private int BG;                      // current blood sugar value
    private int targetBG;                // target bg value
    private int carbs;
    private int fats;
    private int protein;
    private int carbsPerU;               // how many carbs a SINGLE unit of insulin can deal with
    private int bgPerU;                  // how much your BG will drop with 1 unit of insulin
    private double activeInsulin = 0;

    public variables(int BG, int targetBG, int carbs, int fats, int protein, int carbsPerU, int bgPerU, double activeInsulin) {
        this.BG = BG;
        this.targetBG = targetBG;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
        this.carbsPerU = carbsPerU;
        this.bgPerU = bgPerU;
        this.activeInsulin = activeInsulin;
    }

    /**
     * fsdfd
     **/
    @Override
    public String toString() {
        return "variables{" +
                "BG=" + BG +
                ", targetBG=" + targetBG +
                ", carbs=" + carbs +
                ", fats=" + fats +
                ", protein=" + protein +
                ", carbsPerU=" + carbsPerU +
                ", bgPerU=" + bgPerU +
                ", activeInsulin=" + activeInsulin +
                '}';
    }

    public double insulinCalc(){

        double dosage=0;

        if (this.activeInsulin > 0) {
            //calculate dosage to reach target
            int temp = this.BG - this.targetBG;        // store BG difference should be a value > 0
            if (temp >= 0) {
                dosage = temp / bgPerU;                // add the dosage needed to
            }
            temp = this.carbs / this.carbsPerU;
            dosage += temp;
            dosage -= this.activeInsulin;
        }
        else if(this.activeInsulin == 0){
            int temp = this.BG - this.targetBG;
            dosage = temp / this.bgPerU;
            temp = this.carbs / this.carbsPerU;
            dosage += temp;
        }
        else
            System.out.println("Line 59 Error Marie aka activeInsulin");
        return dosage;
    }

}
