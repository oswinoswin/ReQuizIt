package com.example.requizit.model.Question;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    private  @Id @GeneratedValue int id;
    String text;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Option> options;

    public Question(String text, List<Option> options) {
        this.text = text;
        this.options = options;
    }

    public Question() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString(){
        return "[(" +id +") "+ this.text + String.join("\t|", options.toString()) + "]";
//        return "Question{" + "id=" + this.id + ", text='" + this.text + '\'' +
//                ", options='{" + String.join("| ", options) + '\'' + '}';
    }

    public int getId() {
        return this.id;
    }
}
