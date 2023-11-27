package net.shuaiwu.pattern.command;

/**
 * 音响系统
 *
 * @author shuaiwu
 * @date 2023-11-27 15:38
 */
public class Stereo {

    public void on(){
        System.out.println("Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }

    public void setCD(){
        System.out.println("Stereo setCD");
    }

    public void setDVD(){
        System.out.println("Stereo setDVD");
    }

    public void setRadio(){
        System.out.println("Stereo setRadio");
    }

    public void setVolume(int volume){
        System.out.println("Stereo setVolume: " + volume);
    }

}
