(function() {
    'use strict';

    angular
        .module('blog01App')
        .controller('EntryDetailController', EntryDetailController);

    EntryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Entry', 'Blog', 'Tag'];

    function EntryDetailController($scope, $rootScope, $stateParams, previousState, entity, Entry, Blog, Tag) {
        var vm = this;

        vm.entry = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('blog01App:entryUpdate', function(event, result) {
            vm.entry = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
