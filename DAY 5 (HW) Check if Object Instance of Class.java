var checkIfInstanceOf = function(obj, classFunction) {
    if (typeof classFunction !== 'function' || !classFunction.prototype) {
        return false;
    }
    if (obj === null || obj === undefined) {
        return false;
    }
    let proto = Object.getPrototypeOf(Object(obj));
    while (proto !== null) {
        if (proto === classFunction.prototype) {
            return true;
        }
        proto = Object.getPrototypeOf(proto);
    }
    return false;
};
