import java.util.ArrayList;

public class Warrior {

    private String name;
    private int life;
    private boolean knight;
    private boolean thief;
    private boolean mage;
    private ArrayList<String> potions;

    public Warrior(String name) {
        this.name = name;
        this.life = 100;
        this.knight = false;
        this.thief = false;
        this.mage = false;
        this.potions = new ArrayList<>();
        potions.add(0, "Health Potion");
        potions.add(1, "Health Potion");
        potions.add(2, "Health Potion");
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public boolean isKnight() {
        return knight;
    }

    public boolean isThief() {
        return thief;
    }

    public boolean isMage() {
        return mage;
    }

    public ArrayList<String> getPotions() {
        return potions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = this.life - life;
    }

    public void setKnight(boolean knight) {
        this.knight = knight;
    }

    public void setThief(boolean thief) {
        this.thief = thief;
    }

    public void setMage(boolean mage) {
        this.mage = mage;
    }

    public void setPotions(ArrayList<String> potions) {
        this.potions = potions;
    }

    public boolean drinkPotion(){
        if (potions.size()>0){
            this.life += 50;
            if(this.life>100){
                this.life = 100;
            }
            potions.remove(potions.size()-1);
            return true;
        }else{
            return false;
        }
    }

    public String returnRace(){
        if (knight){
            return "cavaler";
        }
        if (thief){
            return "haiduc";
        }
        if (mage){
            return "vrajitor";
        }
        return null;
    }

    public int swordAttack(){
        if (knight) {
            return 30;
        }
        if (thief){
            return 24;
        }
        if (mage){
            return 18;
        }
        return -1;
    }

    public int stealthAttack(){
        if (knight){
            return 18;
        }
        if (thief) {
            return 30;
        }
        if (mage){
            return 24;
        }
        return -1;
    }

    public int spellAttack(){
        if (knight){
            return 24;
        }
        if (thief){
            return 18;
        }
        if (mage){
            return 30;
        }
        return -1;
    }
}
