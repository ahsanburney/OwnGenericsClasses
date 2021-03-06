package com.ahsanburney;

import java.util.ArrayList;

/**
 * Created by Kulsum on 6/19/2017.
 */
public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean  addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() + " is already on this team");
            return false;
        }else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayer(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int outSource, int theirSource){
        if(outSource > theirSource){
            won++;
        }else if (outSource == theirSource){
            tied++;
        }else {
            lost++;
        }
        played++;
        if(opponent !=null){
            opponent.matchResult(null,theirSource,outSource);
        }
    }

    public int ranking(){
         return (won * 2) + tied;
    }
    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1;
        } else if(this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
