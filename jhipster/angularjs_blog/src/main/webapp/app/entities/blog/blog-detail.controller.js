(function() {
    'use strict';

    angular
        .module('angularjsBlogApp')
        .controller('BlogDetailController', BlogDetailController);

    BlogDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Blog', 'User'];

    function BlogDetailController($scope, $rootScope, $stateParams, previousState, entity, Blog, User) {
        var vm = this;

        vm.blog = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('angularjsBlogApp:blogUpdate', function(event, result) {
            vm.blog = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
