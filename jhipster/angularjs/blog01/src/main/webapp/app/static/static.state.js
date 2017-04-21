(function() {
    'use strict';

    angular
        .module('blog01App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('static', {
            parent: 'admin-jobs',
            url: '/static',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/static/static.html',
                    controller: 'StaticController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
