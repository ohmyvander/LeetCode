int lengthOfLongestSubstring(char* s) {
    int i = 0, rm = 0, len = 0, tmp;
    int hash[128] = {0};
    char c;
    while (*s != '\0') {
        c = *s;
        if (hash[c] > 0 && hash[c] >= rm) {
            rm += hash[c] - rm;
        }
        hash[c] = i + 1;
        tmp = i + 1 - rm;
        len = len >= tmp ? len : tmp;
        i++;
        s++;
    }
    return len;
}