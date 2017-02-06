package com.example.cs3_sizebook;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chris on 2/3/2017.
 * Records the data for a person. Name date and various sizes.
 */

public class Person implements Serializable {
    private String name;
    private String date;
    private Double neck;
    private Double bust;
    private Double chest;
    private Double waist;
    private Double hip;
    private Double inseam;
    private String comment;

    /**
     * This method returns a string fit for listing the 4 required sizes in the list
     * If they don't exist then they aren't added to the view.
     * @return a string composed of name,(and optionally)
     * bust, chest, waist and inseam, separated by new lines
     * This is used for the toString method
     */
    private String listFormat(){
        String string;
        string = this.name;
        if (this.bust != 0){
            string += ("\nBust: " +this.bust);
        }
        if (this.chest != 0){
            string += ("\nChest: " +this.chest);
        }
        if (this.waist != 0){
            string += ("\nWaist: " +this.waist);
        }
        if (this.inseam != 0){
            string += ("\nInseam: " +this.inseam);
        }

        return string;
    }

    /**
     * Instead of returning a object id it returns the name
     * and optionally the bust, chest, waist, and inseam, separated by new lines.
     * @return see above
     */
    @Override
    public String toString() {
        return (listFormat());
    }

    /**
     * Takes a string and returns a double rounded to the nearest 0.5
     * if the string is empty then it returns 0.0 instead
     * @param string a string in double format
     * @return a double rounded to nearest 0.5
     */
    public Double stringToRoundDouble(String string){
        if (string == null || string.isEmpty()){
            return 0.0;
        }
        else{
            Double temp = Double.parseDouble(string);
            return Math.round(temp * 2) / 2.0d;
        }


    }
    /**
     * Getters and Setters for the data
     * The setters round it to the nearest 0.5 before setting the value
     * The formula for rounding taken from
     * http://stackoverflow.com/questions/16806987/rounding-to-the-nearest-half-not-the-nearest-whole
     * On 2/3/17
     */
    public  String getName(){
        return name;
    }
    public String getDate() {
        return date;
    }
    public Double getNeck() {
        return neck;
    }

    public Double getBust() {
        return bust;
    }

    public Double getChest() {
        return chest;
    }

    public Double getWaist() {
        return waist;
    }

    public Double getHip() {
        return hip;
    }

    public Double getInseam() {
        return inseam;
    }

    public String getComment() {
        return comment;
    }


    public void setName(String name){this.name = name;}


    public void setDate(String date) {
        this.date = date;
    }

    /**
     * These setters change the value from a string to a double before rounding it
     * this is done in the method stringToRoundDouble
     * All of these setters take a String from the text boxes in the view
     * @param neck
     */
    public void setNeck(String neck) {
        this.neck = stringToRoundDouble(neck);
    }

    public void setBust(String bust) {
        this.bust = stringToRoundDouble(bust);
    }

    public void setChest(String chest) {
        this.chest = stringToRoundDouble(chest);
    }

    public void setWaist(String waist) {
        this.waist = stringToRoundDouble(waist);
    }

    public void setHip(String hip) {
        this.hip = stringToRoundDouble(hip);
    }

    public void setInseam(String inseam) {
        this.inseam = stringToRoundDouble(inseam);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
