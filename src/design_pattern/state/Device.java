package design_pattern.state;
/*
*
* */
public class Device {
    private State state = OffState.getInstance();

    public void changeState(State state){
        this.state = state;
    }

    public String getState(){
        return state.toString();
    }

    public void doUse(){
        state.doUse(this);
    }
    public void doOn(){
        state.doOn(this);
    }
    public void doOff(){
        state.doOff(this);
    }
    public void doDown(){
        state.doDown(this);
    }
    public void doFix(){
        state.doFix(this);
    }

}
