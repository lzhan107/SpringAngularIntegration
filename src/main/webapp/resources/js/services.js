'use strict';

/* Services */

var AppServices = angular.module('SyslogApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory('SystemeventService', function($http){
    var promise;
    var SystemeventService = {
        getSystemevents: function(){
            if ( !promise ) {
                promise = $http({method: 'GET', url: 'systemevent/systemevents.json'}).
                        then(function (response){
                            return response.data;
                        });
            }
            return promise;
        }
    };
    return SystemeventService;
});
