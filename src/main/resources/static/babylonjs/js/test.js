function test() {
	var model = $("#model").val();
    var createScene = function () {
        var scene = new BABYLON.Scene(engine);
        scene.clearColor = new BABYLON.Color4.FromInts(128,128,128);
        //Adding a light
        //Adding an Arc Rotate Camera
        var camera = new BABYLON.ArcRotateCamera("Camera", 0, 0.8, 10, BABYLON.Vector3.Zero(), scene);
        camera.wheelprecision = 100;
        camera.attachControl(canvas, false);
    
        // The first parameter can be used to specify which mesh to import. Here we import all meshes
        BABYLON.SceneLoader.Append("./3dModel/", model, scene, function (newMeshes) {
            scene.activeCamera = null;
            scene.createDefaultCameraOrLight(true);
            scene.activeCamera.attachControl(canvas, false);

        });
        return scene;
    }
__createScene = createScene;
    
    var engine = new BABYLON.Engine(canvas, true, { preserveDrawingBuffer: true, stencil: true });
    var scene = createScene();

    engine.runRenderLoop(function () {
            scene.render();
    });

    window.addEventListener("resize", function () {
        engine.resize();
    });
}
