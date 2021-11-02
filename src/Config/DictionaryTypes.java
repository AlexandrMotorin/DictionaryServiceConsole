package Config;

public enum DictionaryTypes {
    ENGLISH_DICTIONARY,
    NUMERIC_DICTIONARY;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
