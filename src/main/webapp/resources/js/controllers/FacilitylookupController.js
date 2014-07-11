'use strict';

var FacilitylookupController = function($scope, $http) {
    $scope.facilitylookupListHide = true;
    $scope.collapseIconHide = false;
    $scope.expandIconHide = true;

    $scope.facilityVisualizationHide = true;
    $scope.expandVisualizationIconHide = true;
    $scope.collapseVisualizationIconHide = false;

    $scope.getAllFacilities = function() {
        $http.get('facilitylookup/facilitylookup.json').success(function(facilitylookupList) {
            $scope.facilities = facilitylookupList;
        });
    };
    $scope.addFacility = function(newFacility) {
        $http.post('facilitylookup/addFacilitylookup/' + newFacility).success(function() {
            $scope.getAllFacilities();
        });
    };
    $scope.deleteFacility = function(facility) {
        $http.delete('facilitylookup/deleteFacilitylookup/' + facility).success(function() {
            $scope.getAllFacilities();
        });
    };
    $scope.deleteAllFacilities = function() {
        $http.delete('facilitylookup/removeAllFacilitylookup/').success(function() {
        });
    };
    $scope.showFacilitylookupListClick = function() {
        $scope.facilitylookupListHide = false;
        $scope.collapseIconHide = true;
        $scope.expandIconHide = false;
        if ($scope.facilities === undefined) {
            $scope.getAllFacilities();
        }
    };
    $scope.hideFacilitylookupListClick = function() {
        $scope.facilitylookupListHide = true;
        $scope.collapseIconHide = false;
        $scope.expandIconHide = true;
    };
    $scope.showFacilityVisualizationClick = function() {
        $scope.getFacilityVisualization();
        $scope.facilityVisualizationHide = false;
        $scope.collapseVisualizationIconHide = true;
        $scope.expandVisualizationIconHide = false;
    };
    $scope.hideFacilityVisualizationClick = function() {
        $scope.facilityVisualizationHide = true;
        $scope.collapseVisualizationIconHide = false;
        $scope.expandVisualizationIconHide = true;
    };
    $scope.getFacilityVisualization = function() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'message');
        data.addColumn('number', 'facilityLookupCode');
        data.addColumn('number', 'id');
        
        angular.forEach($scope.facilities, function(facility){
           data.addRow([facility.message, facility.facilityLookupCode, facility.id]); 
        });
        var chart = new google.visualization.PieChart(document.getElementById('test_chart'));
        chart.draw(data, {width: 400, height: 240});
    };
    $scope.getAllFacilities();
};