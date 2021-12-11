package model;

public class TravelDestination extends BaseModel {
    private int _id;
    private int _countryId;
    private String _benutzer;

    public TravelDestination() {
    }

    public TravelDestination(int id, String benutzer, int countryId) {
        _id = id;
        _countryId = countryId;
        _benutzer = benutzer;
    }

    public int getCountryId() {
        return _countryId;
    }

    public void setCountryId(int id) {
        this._countryId = id;
    }

    public String getBenutzer() {
        return _benutzer;
    }

    public void setBenutzer(String title) {
        this._benutzer = title;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
}
