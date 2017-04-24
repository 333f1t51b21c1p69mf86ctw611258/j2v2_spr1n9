(function() {
    'use strict';

    angular
        .module('blog01App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('test', {
            parent: 'common',
            url: '/test',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Static'
            },
            views: {
                'content@': {
                    templateUrl: 'app/common/test/test.html',
                    controller: 'TestController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
