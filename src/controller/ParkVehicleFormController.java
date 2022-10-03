package controller;

class Park{
    private String type;
    private int in;

    public Park(String type, int in) {
        this.setType(type);
        //this.slot = slot;
        this.setIn(in);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }
}
public class ParkVehicleFormController {
    public static Park []park=new Park[14];
    static {
        Park_SystemController.park1=park;
        park[0]=new Park("Van",0);
        park[1]=new Park("Van",0);
        park[2]=new Park("Van",0);
        park[3]=new Park("Van",0);
        park[4]=new Park("Cargo Lorry",0);
        park[5]=new Park("Cargo Lorry",0);
        park[6]=new Park("Cargo Lorry",0);
        park[7]=new Park("Cargo Lorry",0);
        park[8]=new Park("Cargo Lorry",0);
        park[9]=new Park("Cargo Lorry",0);
        park[10]=new Park("Cargo Lorry",0);
        park[11]=new Park("Van",0);
        park[12]=new Park("Van",0);
        park[13]=new Park("Bus",0);
    };
    /*void initialize(){
    }*/
    public static String getSlot(String vType){

        for (int i = 0; i <park.length ; i++) {
            if (vType.equals(park[i].getType())){
                if (park[i].getIn()==0){
                    //park[i].setIn(1);
                    return (i+1)+"";

                }/*else if (park[i].getIn()==1){
                    return (i+1)+"";
                }*/
            }
        }
        return "";
    }
}
