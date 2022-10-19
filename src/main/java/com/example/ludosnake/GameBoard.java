package com.example.ludosnake;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    static  int tileSize = 40;
    static  int height = 40;
    static  int width = 40;
    static ArrayList<Pair<Integer, Integer>> positionCoordinates;
    static ArrayList<Integer>snakeLadderPosition;

    public GameBoard(){
        populateSnakeLadderPosition();
        populatePositionCoordinate();
    }

    public int getXValue(int piecePosition){
        if(piecePosition <= 100 && piecePosition >= 1){
            return positionCoordinates.get(piecePosition).getKey();
        }
        else return positionCoordinates.get(1).getKey();
    }

    public int getYValue(int piecePosition){
        if(piecePosition <= 100 && piecePosition >= 1){
            return positionCoordinates.get(piecePosition).getValue();
        }
        else return positionCoordinates.get(1).getValue();
    }

    static private  void populatePositionCoordinate(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer, Integer>(20, 380));
        for (int i = height-1; i >= 0 ; i--) {
            for (int j = width-1; j >= 0 ; j--) {
                int xTilePos, yTilePos, pas;
                if(i % 2 != 0){
                    xTilePos = tileSize*width - (tileSize/2 + j*tileSize);
                }
                else {
                    xTilePos = tileSize/2 + j * tileSize;
                }
                yTilePos = tileSize/2 + i*tileSize;
                positionCoordinates.add(new Pair<>(xTilePos, yTilePos));

            }
        }
        for (int i = 0; i < positionCoordinates.size(); i++) {
            System.out.println(i + " x: " + positionCoordinates.get(i).getKey() + " y: " + positionCoordinates.get(i).getValue());

        }
    }

    private void populateSnakeLadderPosition(){
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4, 25);
        snakeLadderPosition.set(13, 46);
        snakeLadderPosition.set(27, 5);
        snakeLadderPosition.set(33, 49);
        snakeLadderPosition.set(40, 3);
        snakeLadderPosition.set(43, 18);
        snakeLadderPosition.set(13, 46);
        snakeLadderPosition.set(50, 69);
        snakeLadderPosition.set(54, 31);
        snakeLadderPosition.set(42, 63);
        snakeLadderPosition.set(43, 18);

    }
    public static void main(String[] args){
        populatePositionCoordinate();
    }

}
