package com.example.badadventuregame;

public enum PlayerState {
    ACTIVE,
    SLEEPING,
    RUNNINGAWAY,   //When leaving the room which has a monster
    DEAD,
    ATTACKING,
    MOVING          //When leaving the room which does not have a monster
}
