/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.korecky.nlp.library;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author vkorecky
 */
public class BasicTextProcessing {

    /**
     * Normalize text
     *
     * @param input: Input string
     * @param removeAccents: Remove accents form the input text
     * @return Output string
     */
    public String normalizeText(String input, boolean removeAccents) {

        // Convert text to lowercase        
        String output = input.toLowerCase();

        // Remove accents 
        if (removeAccents) {
            output = StringUtils.stripAccents(output);
        }

        return output;
    }

    /**
     * Segments and calculate words in the input text
     *
     * @param input: Input string
     * @param normalizeText: Indicator, if text should be normalized before
     * counting
     * @param removeAccents: Indicator, if should be removed accent in
     * normalization process
     * @return Sorted TreeMap by count
     */
    public TreeMap<String, Long> wordSegmentation(String input, boolean normalizeText, boolean removeAccents) {
        HashMap<String, Long> map = new HashMap<>();
        WordCountComparator comparator = new WordCountComparator(map);
        TreeMap<String, Long> sorted_map = new TreeMap<String, Long>(comparator);

        if (normalizeText) {
            input = normalizeText(input, removeAccents);
        }

        // Words segmentation and calculation
        Pattern pattern = Pattern.compile("[a-zA-Z\\u00C1\\u00C2\\u00C4\\u00C7\\u00C9\\u00CB\\u00CD\\u00CE\\u00D3\\u00D4\\u00D6\\u00DA\\u00DC\\u00DD\\u00DF\\u00E1\\u00E2\\u00E4\\u00E7\\u00E9\\u00EB\\u00ED\\u00EE\\u00F3\\u00F4\\u00F6\\u00FA\\u00FC\\u00FD\\u0102\\u0103\\u0104\\u0105\\u0106\\u0107\\u010C\\u010D\\u010E\\u010F\\u0110\\u0111\\u0118\\u0119\\u011A\\u011B\\u0139\\u013A\\u013D\\u013E\\u0141\\u0142\\u0143\\u0144\\u0147\\u0148\\u0150\\u0151\\u0154\\u0155\\u0158\\u0159\\u015A\\u015B\\u015E\\u015F\\u0160\\u0161\\u0162\\u0163\\u0164\\u0165\\u016E\\u016F\\u0170\\u0171\\u0179\\u017A\\u017B\\u017C\\u017D\\u017E]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group() != null) {
                String foundString = matcher.group().trim();
                if (map.containsKey(foundString)) {
                    map.replace(foundString, map.get(foundString) + 1);
                } else {
                    map.put(foundString, 1L);
                }
            }
        }

        sorted_map.putAll(map);
        return sorted_map;
    }

    class WordCountComparator implements Comparator<String> {

        Map<String, Long> base;

        public WordCountComparator(Map<String, Long> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}
