package org.example.service.criteriaService;

public class SelectionCriteriaFactory {
    public static ICriteriaStrategy getSelectionCriteria(String criteria) {
        return switch (criteria) {
            case "Highest rating" -> new HighestRatingCriteria();
            case "Lowest cost" -> new LowestCostCriteria();
            default -> throw new IllegalArgumentException("Invalid selection criteria: " + criteria);
        };
    }
}
