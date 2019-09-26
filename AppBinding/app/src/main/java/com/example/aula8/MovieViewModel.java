package com.example.aula8;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieViewModel extends ViewModel {

    // ViewModel set the attributes as statics
    private String title;
    private Integer year;
    // MutableLiveData to change attributes values
    private MutableLiveData<Integer> likes;
    private MutableLiveData<String> hype;

    public MovieViewModel() {
        this.title = "A Lagoa Azul";
        this.year = 1980;
        this.likes = new MutableLiveData<>();
        this.likes.setValue(0);
        this.hype = new MutableLiveData<>();
        this.hype.setValue("LOW");
    }

    public void onLike() {
        likes.setValue(likes.getValue()+1);
        changeHype();
    }

    public void changeHype() {
        if (likes.getValue() < 10)
            hype.setValue("LOW");
        else if (likes.getValue() < 25)
            hype.setValue("MEDIUM");
        else
            hype.setValue("HIGH");
    }

    public MutableLiveData<String> getHype() {
        return hype;
    }

    public void setHype(MutableLiveData<String> hype) {
        this.hype = hype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public MutableLiveData<Integer> getLikes() {
        return likes;
    }

    public void setLikes(MutableLiveData<Integer> likes) {
        this.likes = likes;
    }
}
