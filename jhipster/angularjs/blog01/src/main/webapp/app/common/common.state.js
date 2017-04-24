(function() {
    'use strict';

    angular
        .module('blog01App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('common', {
            abstract: true,
            parent: 'app'
        });
    }
})();
