package com.gromoks.webstatistic.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "LINE_INFO")
public class LineStatistic {
    @Id
    @Column(name = "ROW_NUMBER")
    private int rowNumber;

    @Column(name = "LONGEST_WORDS")
    private String longestWords;

    @Column(name = "SHORTEST_WORDS")
    private String shortestWords;

    @Column(name = "LENGTH")
    private int length;

    @Column(name = "AVERAGE_WORD_LENGTH")
    private double averageWordLength;

    @OneToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private FileStatistic fileStatistic;

    public LineStatistic() {
    }

    public LineStatistic(int rowNumber, String longestWords, String shortestWords, int length, double averageWordLength, FileStatistic fileStatistic) {
        this.rowNumber = rowNumber;
        this.longestWords = longestWords;
        this.shortestWords = shortestWords;
        this.length = length;
        this.averageWordLength = averageWordLength;
        this.fileStatistic = fileStatistic;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
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

    public FileStatistic getFileStatistic() {
        return fileStatistic;
    }

    public void setFileStatistic(FileStatistic fileStatistic) {
        this.fileStatistic = fileStatistic;
    }
}
