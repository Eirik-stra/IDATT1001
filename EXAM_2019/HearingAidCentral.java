package EKSAMEN_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class HearingAidCentral
 *
 * Although there is not explicitly set an upper limit for the amount of aids in a central, there is specified that
 * the maximum unique id of a hearing aid. Therefore I have defined this as the upper limit for number of
 * hearing aid registered. (subtracting the minimum id, of course).
 *
 */
public class HearingAidCentral {
    private int aidsNo = HearingAid.MIN_ID; // To properly set the id for a new hearing aid.
    private String name;
    private List<HearingAid> hearingAids;

    /**
     * Creates an instance of class HearingListCentral with an empty register.
     *
     * @param name String, name of central.
     * @throws IllegalArgumentException if the name is blank
     */
    public HearingAidCentral(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("The centrals name cannot be empty");
        }

        this.name = name;
        this.hearingAids = new ArrayList<>();
    }

    /** 3b
     * Register a new hearing aid.
     *
     * The hearing aid cannot be registered if it already exists in the registry or if the max id has been reached.
     *
     * @param type String, type of hearing aid to be registered.
     * @return boolean, if the register was successful.
     */
    public boolean regHearingAid(String type) {
        if (type.isBlank() || this.aidsNo == HearingAid.MAX_ID ) {
            return false;
        }

        return this.hearingAids.add(new HearingAid(type, this.aidsNo++)); // increment the amount of hearing aids
    }

    /**
     * Checks if a hearing aid is registered.
     *
     * I could have looped through all the elements in the list and used the .equals method directly,
     * but the inbuilt .contains method does this indirectly.
     *
     * @param hearingAid HearingAid, hearing aid to be checked for
     * @return boolean, if the hearing aid is registered
     */
    private boolean isRegistered(HearingAid hearingAid) {
        // check if the new hearing aid is not null
        if (hearingAid == null) {
            return false;
        }
        return this.hearingAids.contains(hearingAid);
    }

    /** 3c
     * Rents a hearing aid to the specified renter.
     *
     * The hearing aid cannot be rented if it is not registered or is already rented.
     *
     * @param type String, type of hearing aid to be rented.
     * @param renter String, name of the person to rent the hearing aid.
     * @return boolean, if the hearing aid could be rented.
     */
    public boolean rentHearingAid(String type, String renter) {
        HearingAid hearingAid = getAvailableHearingAid(type);
        if (hearingAid == null || !isRegistered(hearingAid)) {
            return false;
        }

        return hearingAid.rentHearingAid(renter);
    }

    /**
     * Finds and returns the first hearing aid in the register which is not rented.
     *
     * Performs a sequential search in the list of hearing ads and returns the first matching element. This is a helper method
     * and if it was to be used externally it should return a deep copy of the object because of the principle of
     * composition.
     *
     * @param type String, type of hearing aid.
     * @return HearingAid, hearing aid if found, else null
     */
    private HearingAid getAvailableHearingAid(String type) {
        for (HearingAid h : this.hearingAids) {
            if (h.getType().equalsIgnoreCase(type) && !h.isRented()) {
                return h;
            }
        }

        return null;
    }

    /** 3d
     * Terminates a rental contract.
     *
     * Checks that the hearing aid is not null and if it is not currently beeing rented.
     *
     * @param type, String, type of hearing aid which rental is to be terminated.
     * @return boolean, if the termination was successful.
     */
    public boolean terminateRental(String type, String renter) {
        HearingAid hearingAid = getHearingAid(type, renter);

        if (hearingAid == null || !hearingAid.isRented()) {
            return false;
        }

        return hearingAid.terminateRental();
    }

    /**
     * Finds a hearing aid rented by the specified person/renter.
     *
     * Performs a sequential search and finds the first element to match the type and renter. This is a helper method
     * and if it was to be used externally it should return a deep copy of the object because of the principle of
     * composition.
     *
     * @param type String, type of hearing aid.
     * @param renter String, person who is renting.
     * @return HearingAid, the hearing aid rented by the specified person if it exists, else null
     */
    private HearingAid getHearingAid(String type, String renter) {
        for (HearingAid h : this.hearingAids) {
            if (h.getType().equalsIgnoreCase(type) && h.getRenter().equalsIgnoreCase(renter)) { // ignore casing
                return h;
            }
        }

        return null;
    }

    /** 3e
     * Returns information about the hearing aid central and its registered aids.
     * I chose to override the .toString method including the centrals name and number of hearing aids, because this
     * eases the implemetation of printing all the information about the central in the client.
     *
     * @return String, the formatted string.
     */
    @Override
    public String toString() {
        return this.name + '\n' +
                "Number of hearing aids:  " + aidsNo + '\n' +
                "Hearing aids: \n" + hearingAids.stream()
                                                .map(HearingAid::toString)
                                                .collect(Collectors.joining("\n"));
    }

    /**
     * Searches all registered hearing aids and returns those matching the specified type.
     *
     * Uses a stream, but the same result could have been acquired using an enhanced for-loop, but this solution is
     * less verbose. Returns new list containing deep copies of the objects because of the principle of composition.
     *
     * @param type String, type to be searched for.
     * @return List of hearing aids, hearing aids with of the same type
     */
    public List<HearingAid> searchHearingAids(String type) {
        return this.hearingAids.stream()
                .filter(h -> h.getType().equalsIgnoreCase(type))
                .map(HearingAid::new)
                .collect(Collectors.toList());
    }
}

