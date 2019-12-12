package EKSAMEN_2019;

/**
 * Class HearingAid.
 *
 * A hearing aid has a unique id in range 1001-9999, a type, if it is rented and so by whom.
 * An aid of the same type can exist in several hearing aid centrals, but it will not be physically the same aid.
 * Therefore I chose to let the id be set by the central, and not as a static counter on this class.
 *
 */
public class HearingAid {
    public static final int MIN_ID = 1001;
    public static final int MAX_ID = 9999;
    private final int id;
    private final String type;
    private boolean isRented;
    private String renter;

    /**
     * Creates an instance of class HearingAid.
     *
     * @param type String, type of hearing aid
     * @throws IllegalArgumentException if type is empty or id is out of range.
     */
    public HearingAid(String type, int id) {
        if (type.isBlank()) {
            throw new IllegalArgumentException("Type of hearing aid must have a value.");
        } else if (id < MIN_ID || id > MAX_ID) {
            throw new IllegalArgumentException("Invalid value for argument 'id': " + id +
                    "\n Must be in range [" + MIN_ID + "-" + MAX_ID + "]");
        }

        this.id = id;
        this.type = type;
        this.isRented = false; // default is not rented
    }

    /**
     * Copy constructor - creates a deep copy of the hearing aid.
     *
     * @param aid HearingAid, hearing aid to be copied.
     */
    public HearingAid(HearingAid aid) {
        this(aid.type, aid.id);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getRenter() {
        return renter;
    }

    /**
     * Sets the hearing aid as rented by the specified renter. The hearing aid cannot be rented to a person if it
     * is already being rented by someone else.
     *
     * @param renter String, the new renter.
     * @return boolean, if the hearing aid could be rented.
     */
    public boolean rentHearingAid(String renter) {
        if (this.isRented || renter.isBlank()) {
            return false;
        }

        this.isRented = true;
        this.renter = renter;

        return true;
    }

    /**
     * Terminates the rental contract. Sets the renter to an empty string.
     * @return boolean, successfully terminated the rental.
     */
    public boolean terminateRental() {
        this.isRented = false;
        this.renter = "";

        return true;
    }

    /**
     * Checks if two objects of class HearingAid are equal. They are defined as equal if they share id.
     *
     * @param o Object, object to be checked for equality.
     * @return boolean, if the objects are equal
     */
    @Override
    public boolean equals(Object o) {
        // check for object reference
        if (this == o) return true;
        // check if the object is null or of another class
        if (o == null || getClass() != o.getClass()) return false;
        // Cast object to class HearingAid
        HearingAid that = (HearingAid) o;
        return id == that.id;
    }

    /**
     * Generates a string contaning the objects state in following format:
     *
     *      3003 Varslingsutstyr utleid til Per Olsen
     *
     *      (and if it is available for rent)
     *       3003 Varslingsutstyr ledig
     *
     * @return String, formatted string
     */
    @Override
    public String toString() {
        return this.id + " " + this.type + (this.isRented ? " utleid til " + this.renter : " ledig");
    }
}
