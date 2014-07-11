'use strict';

angular.module('SyslogApp', ['SyslogApp.filters', 'SyslogApp.services', 'SyslogApp.directives', 'SyslogChart','ui.bootstrap']);

angular.module('SyslogApp').config(['$routeProvider', function($routeProvider) {
        $routeProvider.
                when('/systemevent', {
            templateUrl: 'systemevent/template',
            controller: SystemeventController
        })
                .when('/facilitylookup', {
            templateUrl: 'facilitylookup/template',
            controller: FacilitylookupController
        })
                .when('/prioritylookup', {
            templateUrl: 'prioritylookup/template',
            controller: PrioritylookupController
        })
                .otherwise({redirectTo: '/systemevent'});
    }]);

angular.module('SyslogChart', [])
        .directive('syslogChart', function() {
    return {
        restrict: 'A',
        link: function($scope, $elm, $attr) {
            $scope.$watch($attr.data, function(param) {
                var data = new google.visualization.DataTable();
                //data.addColumn('number', 'id');
                data.addColumn('string', 'facilityLookupCode');
                data.addColumn('number', 'message');

                angular.forEach(param, function(row) {
                    data.addRow([row.facilitylookupcode, row.message]);
                });

                var chart;
                if ($attr.type === 'PieChart'){
                    chart = new google.visualization.PieChart($elm[0]);
                }else if ($attr.type === 'ColumnChart'){
                    chart = new google.visualization.ColumnChart($elm[0]);
                }else if ($attr.type === 'BarChart'){
                    chart = new google.visualization.BarChart($elm[0]);
                }else{
                    chart = new google.visualization.Table($elm[0]);
                }
                chart.draw(data, options);
            });
        }
    };
});

