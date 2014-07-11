'use strict';

var SystemeventController = function($scope, $http, $filter, SystemeventService) {
    $scope.customerIDDisabled = false;
    $scope.receivedAtDisabled = false;
    $scope.deviceReportedTimeDisabled = false;
    $scope.facilityDisabled = false;
    $scope.priorityDisabled = false;
    $scope.fromHostDisabled = false;
    $scope.messageDisabled = false;
    $scope.NTSeverityDisabled = false;
    $scope.importanceDisabled = false;
    $scope.eventSourceDisabled = false;
    $scope.eventUserDisabled = false;
    $scope.eventCatrgoryDisabled = false;
    $scope.eventIDDisabled = false;
    $scope.eventBinaryDataDisabled = false;
    $scope.maxAvailableDisabled = false;
    $scope.currUsageDisabled = false;
    $scope.minimumUsageDisabled = false;
    $scope.maximumUsageDisabled = false;
    $scope.infoUnitIDDisabled = false;
    $scope.sysLogTagDisabled = false;
    $scope.eventLogTypeDisabled = false;
    $scope.genericFileNameDisabled = false;
    $scope.systemIDDisabled = false;
    $scope.customerIDButtonHide = true;
    $scope.receivedAtHide = true;
    $scope.deviceReportedTimeHide = true;
    $scope.facilityHide = true;
    $scope.priorityHide = true;
    $scope.fromHostHide = true;
    $scope.messageHide = true;
    $scope.NTSeverityHide = true;
    $scope.importanceHide = true;
    $scope.eventSourceHide = true;
    $scope.eventUserHide = true;
    $scope.eventCatHide = true;
    $scope.eventIDHide = true;
    $scope.eventBinaryDataHide = true;
    $scope.maxAvailableHide = true;
    $scope.currUsageHide = true;
    $scope.minimumUsageHide = true;
    $scope.maximumUsageHide = true;
    $scope.InfoUnitIDHide = true;
    $scope.sysLogTagHide = true;
    $scope.eventLogTypeHide = true;
    $scope.genericFileNameHide = true;
    $scope.systemIDHide = true;
    $scope.queryObj = [{}];
    $scope.systemevents = [];

    $scope.customerIDButtonFieldSelected = function() {
        if ($scope.customerIDButtonHide === true) {
            $scope.customerIDDisabled = true;
            $scope.customerIDButtonHide = false;
            angular.forEach($scope.queryObj, function() {
                if ($scope.queryObj.indexOf('customerID') === -1) {
                    $scope.queryObj.push('customerID');
                }
            });
            $scope.appendQueryString($scope.queryObj);
        } else {
            $scope.customerIDDisabled = false;
            $scope.customerIDButtonHide = true;
            angular.forEach($scope.queryObj, function() {
                var index = $scope.queryObj.indexOf('customerID');
                if (index > -1) {
                    $scope.queryObj.splice(index, 1);
                }
            });
            $scope.appendQueryString($scope.queryObj);
        }
    };
    $scope.receivedAtButtonFieldSelected = function() {
        if ($scope.receivedAtHide === true) {
            $scope.receivedAtDisabled = true;
            $scope.receivedAtHide = false;
            angular.forEach($scope.queryObj, function() {
                if ($scope.queryObj.indexOf('receivedAt') === -1) {
                    $scope.queryObj.push('receivedAt');
                }
            });
            $scope.appendQueryString($scope.queryObj);
        } else {
            $scope.receivedAtDisabled = false;
            $scope.receivedAtHide = true;
            angular.forEach($scope.queryObj, function() {
                var index = $scope.queryObj.indexOf('receivedAt');
                if (index > -1) {
                    $scope.queryObj.splice(index, 1);
                }
            });
            $scope.appendQueryString($scope.queryObj);
        }
    };

    $scope.getSystemevents = function() {
        SystemeventService.getSystemevents().then(function(events) {
            var array = [];
            angular.forEach(events, function(event) {
                var row = {};
                angular.forEach($scope.queryObj, function(obj) {
                    row[obj] = event[obj] !== null ? event[obj] : null;
                });
                array.push(row);
            });
            $scope.afterQuery(array);
        });
    };

    $scope.addSystemevent = function(event) {
        $http({method: 'POST', url: 'systemevents/addSystemevent'}).
                success(function() {

        }).
                error(function(data, status) {
            console.log("Error occured");
        });
    };

    $scope.removeSystemevent = function(event) {
        $http({method: 'DELETE', url: 'systemevents/removeSystemevent'}).
                success(function() {

        }).
                error(function(data, status) {
            console.log("Error occured");
        });
    };

    $scope.removeAllSystemevents = function(event) {
        $http({method: 'DELETE', url: 'systemevents/removeAllSystemevents'}).
                success(function() {

        }).
                error(function() {

        });
    };

    $scope.appendQueryString = function(queryObj) {
        var query = angular.toJson(queryObj);
        query = angular.fromJson(query);
        if (JSON.stringify(query[0]) === '{}') {
            query.shift();
        }
        $scope.queryObj = query;
        $http({method: 'POST', url: 'systemevent/appendQueryString/' + query}).
                success(function() {
        }).
                error(function() {
        });
    };

    $scope.querySystemeventClick = function() {
        $scope.getSystemevents();
    };

    $scope.afterQuery = function(systemevents) {
        $scope.systemevents = systemevents;

    };


    $scope.filteredEvents = [];
    $scope.currentPage = 1;
    $scope.numPerPage = 10;
    $scope.maxSize = 5;
    $scope.headers = $scope.queryObj;

    $scope.numPages = function() {
        console.log("NumPages...");
        return Math.ceil($scope.systemevents.length / $scope.numPerPage);
    };

    $scope.$watch('currentPage + numPerPage', function() {
        console.log("monitor...");
        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
                , end = begin + $scope.numPerPage;
        $scope.filteredEvents = $scope.systemevents.slice(begin, end);
    });
};
