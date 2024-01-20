package net.Lucas.tutorialmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_TUTORIAL = "key.category.tutorialmod.tutorial";
    public static final String KEY_CHANGE_TOOL_EFFECT = "key.tutorialmod.change_tool_effect";

    public static final KeyMapping CHANGE_TOOL_EFFECT_KEY = new KeyMapping(KEY_CHANGE_TOOL_EFFECT,
            KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_EQUAL, KEY_CATEGORY_TUTORIAL);
}
