package com.kuldeep.thoughtworkschallenge;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Kuldeep.Chauhan
 */
public class Conference {

    private List<Tracks> tracks;

    private static final DateFormat df = new SimpleDateFormat("hh:mm a");

    public List<Tracks> getTracks() {
        return tracks;
    }

    public void setTracks(List<Tracks> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {

        String confDetail = "";

        if (getTracks() != null) {

            int i = 1;
            for (Tracks track : getTracks()) {

                confDetail += "Track " + i + "\n";

                for (Proposal proposal : track.getProposals()) {
                    if (proposal.getTitle().contains("Lunch") || proposal.getTitle().contains("Netwoking Event")) {
                        confDetail += (df.format(proposal.getTime()) + " " + proposal.getTitle() +"\n");
                    } else {
                        confDetail += (df.format(proposal.getTime()) + " " + proposal.getTitle() + " " + proposal.getDuration() + "mins\n");
                    }
                }
                i++;
            }

            return confDetail;

        } else {

            return "No Conference";

        }

    }

}
