package com.gromoks.webstatistic.entity;

import javax.persistence.*;

@Entity
@Table(name = "FILE_INFO")
public class FileStatistic {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "LONGEST_WORDS")
    private String longestWords;

    @Column(name = "SHORTEST_WORDS")
    private String shortestWords;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "AVERAGE_WORD_LENGTH")
    private double averageWordLength;

    public FileStatistic() {
    }

    public FileStatistic(int id, String fileName, String longestWords, String shortestWords, int length, double averageWordLength) {
        this.id = id;
        this.fileName = fileName;
        this.longestWords = longestWords;
        this.shortestWords = shortestWords;
        this.length = length;
        this.averageWordLength = averageWordLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLongestWords() {
        return longestWords;
    }

    public void setLongestWords(String longestWords) {
        this.longestWords = longestWords;
    }

    public String getShortestWords() {
        return shortestWords;
    }

    public void setShortestWords(String shortestWords) {
        this.shortestWords = shortestWords;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    @Override
    public String toString() {
        return "FileStatistic{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", longestWords='" + longestWords + '\'' +
                ", shortestWords='" + shortestWords + '\'' +
                ", length=" + length +
                ", averageWordLength=" + averageWordLength +
                '}';
    }
}
