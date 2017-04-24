/**
 * Created by Henrik on 4/24/2017.
 */
(function() {
    'use strict';

    angular
        .module('blog01App')
        .config(html5ModeConfig);

    html5ModeConfig.$inject = ['$locationProvider'];

    function html5ModeConfig($locationProvider) {
        $locationProvider.html5Mode({ enabled: true, requireBase: true });
    }
})();
