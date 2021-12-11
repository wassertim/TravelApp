package model;

public class Country extends BaseModel {
    private int _id;
    private String _title;

    public Country() {
    }

    public Country(int id, String title) {
        _id = id;
        _title = title;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }
}
