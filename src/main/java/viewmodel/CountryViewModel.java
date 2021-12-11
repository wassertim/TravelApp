package viewmodel;

import model.Country;

public class CountryViewModel {
    private Country _country;
    private boolean _traveled;

    public CountryViewModel(Country country, boolean traveled) {
        _country = country;
        _traveled = traveled;
    }

    public Country getCountry() {
        return _country;
    }

    public void setCountry(Country _country) {
        this._country = _country;
    }

    public boolean isTraveled() {
        return _traveled;
    }

    public void setTraveled(boolean _traveled) {
        this._traveled = _traveled;
    }
}
