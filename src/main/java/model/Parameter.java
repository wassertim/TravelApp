package model;

public class Parameter {
    private String _key;
    private String _value;

    public Parameter(String key, String value) {
        this._key = key;
        this._value = value;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String _key) {
        this._key = _key;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String _value) {
        this._value = _value;
    }
}
