package com.thegame.tictactoe.client.model;

public class TicTacToeResults {

   private int no, p1, p2, p3;
   private String position, winner, author,date;
   private boolean status;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TicTacToeResults{" +
                "no=" + no +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", position='" + position + '\'' +
                ", winner='" + winner + '\'' +
                ", status=" + status + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date;
    }
}
