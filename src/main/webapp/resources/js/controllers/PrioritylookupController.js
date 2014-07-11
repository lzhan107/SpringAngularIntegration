'use strict';

var PrioritylookupController = function($scope, $http) {
    $scope.prioritylookupListHide = true;
    $scope.collapseIconHide = false;
    $scope.expandIconHide = true;
    
    $scope.facilityVisualizationHide = true;
    $scope.expandVisualizationIconHide = true;
    $scope.collapseVisualizationIconHide = false;
    $scope.getAllPriorities = function() {
        $http.get('prioritylookup/prioritylookup.json').success(function(prioritylookupList) {
            $scope.priorities = prioritylookupList;
        });
    };
    $scope.addPriority = function(newPriority) {
        $http.post('prioritylookup/addPrioritylookup/' + newPriority).success(function() {
            $scope.getAllPriorities();
        });
    };
    $scope.deletePriority = function(priority) {
        $http.delete('prioritylookup/deletePrioritylookup/' + priority).success(function() {
            $scope.getAllPriorities();
        });
    };
    $scope.deleteAllPriorities = function() {
        $http.delete('prioritylookup/removeAllPrioritylookup/').success(function() {
        });
    };
    $scope.showPrioritylookupListClick = function() {
        $scope.prioritylookupListHide = false;
        $scope.collapseIconHide = true;
        $scope.expandIconHide = false;
        if ($scope.priorities === undefined) {
            $scope.getAllPriorities();
        }
    };
    $scope.hidePrioritylookupListClick = function(){
        $scope.prioritylookupListHide = true;
        $scope.collapseIconHide = false;
        $scope.expandIconHide = true;
    };
    $scope.showPriorityVisualizationClick = function(){
        $scope.getPriorityVisualization();
        $scope.priorityVisualizationHide = false;
        $scope.collapseVisualizationIconHide = true;
        $scope.expandVisualizationIconHide = false;
    };
    $scope.hidePriorityVisualizationClick = function(){
        $scope.priorityVisualizationHide = true;
        $scope.collapseVisualizationIconHide = false;
        $scope.expandVisualizationIconHide = true;
    };
    $scope.getPriorityVisualization = function() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'message');
        data.addColumn('number', 'priorityLookupCode');
        data.addColumn('number', 'id');
        
        angular.forEach($scope.priorities, function(priority){
           data.addRow([priority.message, priority.priorityLookupCode, priority.id]); 
        });
        var chart = new google.visualization.PieChart(document.getElementById('test_chart'));
        chart.draw(data, {width: 400, height: 240});
    };
    $scope.getAllPriorities();
};